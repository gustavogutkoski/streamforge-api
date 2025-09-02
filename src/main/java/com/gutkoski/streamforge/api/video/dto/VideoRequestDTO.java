package com.gutkoski.streamforge.api.video.dto;

import java.util.UUID;

public record VideoRequestDTO(
        String title,
        String description,
        UUID ownerId,
        long fileSize,
        String contentType,
        String bucketName,
        String objectName
) {}
