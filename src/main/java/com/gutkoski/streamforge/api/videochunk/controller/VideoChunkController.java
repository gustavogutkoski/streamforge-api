package com.gutkoski.streamforge.api.videochunk.controller;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;
import com.gutkoski.streamforge.api.videochunk.service.VideoChunkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/video-chunks")
public class VideoChunkController {

    private final VideoChunkService videoChunkService;

    public VideoChunkController(VideoChunkService videoChunkService) {
        this.videoChunkService = videoChunkService;
    }

    @PostMapping
    public VideoChunkResponseDTO save(@RequestBody VideoChunkRequestDTO dto) {
        return videoChunkService.save(dto);
    }

    @GetMapping("/video/{videoId}")
    public List<VideoChunkResponseDTO> getChunksByVideo(@PathVariable UUID videoId) {
        return videoChunkService.findByVideo(videoId);
    }

    @PostMapping("/upload")
    public VideoChunkResponseDTO uploadChunk(
            @RequestParam("videoId") UUID videoId,
            @RequestParam("chunkIndex") Integer chunkIndex,
            @RequestParam("file") MultipartFile file
    ) {
        return videoChunkService.saveChunk(videoId, chunkIndex, file);
    }
}

