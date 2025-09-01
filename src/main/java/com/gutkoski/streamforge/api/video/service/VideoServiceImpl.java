package com.gutkoski.streamforge.api.video.service;

import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;
import com.gutkoski.streamforge.api.video.mapper.VideoMapper;
import com.gutkoski.streamforge.api.video.model.Video;
import com.gutkoski.streamforge.api.video.repository.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public VideoResponseDTO uploadVideo(MultipartFile file, String title) {
        // TODO:  use MinIO as video storage
        Video video = new Video();
        video.setTitle(title);
        Video saved = videoRepository.save(video);
        return VideoMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public VideoResponseDTO getVideoById(UUID id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        return VideoMapper.INSTANCE.toDTO(video);
    }

    @Override
    public List<VideoResponseDTO> getAllVideos() {
        return videoRepository.findAll().stream()
                .map(VideoMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
