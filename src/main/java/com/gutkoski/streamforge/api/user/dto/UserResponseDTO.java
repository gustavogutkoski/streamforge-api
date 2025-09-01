package com.gutkoski.streamforge.api.user.dto;

import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;

import java.util.List;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email,
        List<VideoResponseDTO> videos
) {}
