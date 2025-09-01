package com.gutkoski.streamforge.api.videochunk.service;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;
import com.gutkoski.streamforge.api.video.model.Video;
import com.gutkoski.streamforge.api.videochunk.mapper.VideoChunkMapper;
import com.gutkoski.streamforge.api.videochunk.model.VideoChunk;
import com.gutkoski.streamforge.api.videochunk.repository.VideoChunkRepository;
import com.gutkoski.streamforge.api.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoChunkServiceImpl implements VideoChunkService {

    private final VideoChunkRepository videoChunkRepository;
    private final VideoRepository videoRepository;

    public VideoChunkServiceImpl(VideoChunkRepository videoChunkRepository, VideoRepository videoRepository) {
        this.videoChunkRepository = videoChunkRepository;
        this.videoRepository = videoRepository;
    }

    @Override
    public VideoChunkResponseDTO save(VideoChunkRequestDTO dto) {
        Video video = videoRepository.findById(dto.videoId())
                .orElseThrow(() -> new RuntimeException("Video not found"));

        VideoChunk chunk = VideoChunkMapper.INSTANCE.toEntity(dto);
        chunk.setVideo(video);

        VideoChunk saved = videoChunkRepository.save(chunk);

        return VideoChunkMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public List<VideoChunkResponseDTO> findByVideo(UUID videoId) {
        return videoChunkRepository.findByVideoIdOrderByChunkIndex(videoId)
                .stream()
                .map(VideoChunkMapper.INSTANCE::toDTO)
                .toList();
    }
}

