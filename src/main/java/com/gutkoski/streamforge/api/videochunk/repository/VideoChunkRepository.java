package com.gutkoski.streamforge.api.videochunk.repository;

import com.gutkoski.streamforge.api.videochunk.model.VideoChunk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoChunkRepository extends JpaRepository<VideoChunk, Long> {
    List<VideoChunk> findByVideoIdOrderByChunkIndex(Long videoId);
}

