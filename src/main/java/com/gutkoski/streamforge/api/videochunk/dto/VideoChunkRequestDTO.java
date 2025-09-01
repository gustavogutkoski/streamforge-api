package com.gutkoski.streamforge.api.videochunk.dto;

import java.util.UUID;

public record VideoChunkRequestDTO(
        Integer chunkIndex,
        String storagePath,
        UUID videoId
) {}
