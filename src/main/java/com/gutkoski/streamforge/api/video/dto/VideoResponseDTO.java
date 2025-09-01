package com.gutkoski.streamforge.api.video.dto;

import java.util.UUID;

public record VideoResponseDTO(
        UUID id,
        String title,
        String description,
        UUID ownerId
) {}
