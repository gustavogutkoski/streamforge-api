package com.gutkoski.streamforge.api.video.controller;

import com.gutkoski.streamforge.api.video.dto.VideoRequestDTO;
import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;
import com.gutkoski.streamforge.api.video.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<VideoResponseDTO> createVideo(@RequestBody VideoRequestDTO requestDTO) {
        VideoResponseDTO response = videoService.createVideo(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoResponseDTO> getVideo(@PathVariable UUID id) {
        VideoResponseDTO response = videoService.getVideoById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VideoResponseDTO>> getAllVideos() {
        List<VideoResponseDTO> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoResponseDTO> updateVideo(@PathVariable UUID id,
                                                        @RequestBody VideoRequestDTO requestDTO) {
        VideoResponseDTO updated = videoService.updateVideo(id, requestDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable UUID id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }
}
