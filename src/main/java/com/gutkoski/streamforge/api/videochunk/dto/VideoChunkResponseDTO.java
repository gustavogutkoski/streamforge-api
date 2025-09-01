package com.gutkoski.streamforge.api.videochunk.dto;

import java.util.UUID;

public record VideoChunkResponseDTO(
        UUID id,
        Integer chunkIndex,
        String storagePath,
        UUID videoId
) {}

