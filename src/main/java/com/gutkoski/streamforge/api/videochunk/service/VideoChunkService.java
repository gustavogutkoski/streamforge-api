package com.gutkoski.streamforge.api.videochunk.service;

import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkRequestDTO;
import com.gutkoski.streamforge.api.videochunk.dto.VideoChunkResponseDTO;

import java.util.List;

public interface VideoChunkService {

    VideoChunkResponseDTO save(VideoChunkRequestDTO dto);
    List<VideoChunkResponseDTO> findByVideo(Long videoId);

}
