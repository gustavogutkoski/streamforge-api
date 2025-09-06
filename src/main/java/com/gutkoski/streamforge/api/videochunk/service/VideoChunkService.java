package com.gutkoski.streamforge.api.videochunk.service;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface VideoChunkService {

    VideoChunkResponseDTO save(VideoChunkRequestDTO dto);
    List<VideoChunkResponseDTO> findByVideo(UUID videoId);
    VideoChunkResponseDTO saveChunk(UUID videoId, Integer chunkIndex, MultipartFile file);
}
