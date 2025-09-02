package com.gutkoski.streamforge.api.video.service;

import com.gutkoski.streamforge.api.user.repository.UserRepository;
import com.gutkoski.streamforge.api.video.dto.VideoRequestDTO;
import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;
import com.gutkoski.streamforge.api.video.mapper.VideoMapper;
import com.gutkoski.streamforge.api.video.model.Video;
import com.gutkoski.streamforge.api.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    public VideoServiceImpl(VideoRepository videoRepository,
                            UserRepository userRepository) {
        this.videoRepository = videoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VideoResponseDTO createVideo(VideoRequestDTO dto) {
        var owner = userRepository.findById(dto.ownerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Video video = VideoMapper.INSTANCE.toEntity(dto);
        video.setOwner(owner);

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
        return videoRepository.findAll()
                .stream()
                .map(VideoMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public void deleteVideo(UUID id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
        videoRepository.delete(video);
    }

    @Override
    public VideoResponseDTO updateVideo(UUID id, VideoRequestDTO dto) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));

        video.setTitle(dto.title());
        video.setDescription(dto.description());

        Video updated = videoRepository.save(video);
        return VideoMapper.INSTANCE.toDTO(updated);
    }
}
