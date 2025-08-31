package com.gutkoski.streamforge.api.video.controller;

import com.gutkoski.streamforge.api.video.service.VideoService;
import com.gutkoski.streamforge.api.video.model.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/upload")
    public Video uploadVideo(@RequestParam("file") MultipartFile file,
                             @RequestParam("title") String title) {
        return videoService.uploadVideo(file, title);
    }

    @GetMapping("/{id}")
    public Video getVideo(@PathVariable UUID id) {
        return videoService.getVideoById(id);
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }
}
