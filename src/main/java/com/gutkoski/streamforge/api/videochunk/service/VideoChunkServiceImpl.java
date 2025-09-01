package com.gutkoski.streamforge.api.videochunk.service;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;
import com.gutkoski.streamforge.api.video.model.Video;
import com.gutkoski.streamforge.api.videochunk.model.VideoChunk;
import com.gutkoski.streamforge.api.videochunk.repository.VideoChunkRepository;
import com.gutkoski.streamforge.api.video.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoChunkServiceImpl implements VideoChunkService {

    private final VideoChunkRepository videoChunkRepository;
    private final VideoRepository videoRepository;

    public VideoChunkServiceImpl(VideoChunkRepository videoChunkRepository, VideoRepository videoRepository) {
        this.videoChunkRepository = videoChunkRepository;
        this.videoRepository = videoRepository;
    }

    public VideoChunkResponseDTO save(VideoChunkRequestDTO dto) {
        Video video = videoRepository.findById(dto.videoId())
                .orElseThrow(() -> new RuntimeException("Video not found"));

        VideoChunk chunk = new VideoChunk();
        chunk.setChunkIndex(dto.chunkIndex());
        chunk.setStoragePath(dto.storagePath());
        chunk.setVideo(video);

        VideoChunk saved = videoChunkRepository.save(chunk);

        return new VideoChunkResponseDTO(
                saved.getId(),
                saved.getChunkIndex(),
                saved.getStoragePath(),
                saved.getVideo().getId()
        );
    }

    public List<VideoChunkResponseDTO> findByVideo(Long videoId) {
        return videoChunkRepository.findByVideoIdOrderByChunkIndex(videoId).stream()
                .map(c -> new VideoChunkResponseDTO(
                        c.getId(),
                        c.getChunkIndex(),
                        c.getStoragePath(),
                        c.getVideo().getId()
                ))
                .toList();
    }
}
