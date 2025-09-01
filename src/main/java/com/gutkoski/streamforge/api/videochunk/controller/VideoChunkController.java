package com.gutkoski.streamforge.api.videochunk.controller;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;
import com.gutkoski.streamforge.api.videochunk.service.VideoChunkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<VideoChunkResponseDTO> getChunksByVideo(@PathVariable Long videoId) {
        return videoChunkService.findByVideo(videoId);
    }
}

