package com.gutkoski.streamforge.api.videochunk.repository;

import com.gutkoski.streamforge.api.videochunk.model.VideoChunk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VideoChunkRepository extends JpaRepository<VideoChunk, UUID> {
    List<VideoChunk> findByVideoIdOrderByChunkIndex(UUID videoId);
}

