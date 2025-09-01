package com.gutkoski.streamforge.api.video.service;

import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;
import com.gutkoski.streamforge.api.video.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface VideoService {
    VideoResponseDTO uploadVideo(MultipartFile file, String title);
    VideoResponseDTO getVideoById(UUID id);
    List<VideoResponseDTO> getAllVideos();
}
