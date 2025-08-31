package com.gutkoski.streamforge.api.video.service;

import com.gutkoski.streamforge.api.video.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface VideoService {
    Video uploadVideo(MultipartFile file, String title);
    Video getVideoById(UUID id);
    List<Video> getAllVideos();
}
