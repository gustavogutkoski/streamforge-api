package com.gutkoski.streamforge.api.video.repository;

import com.gutkoski.streamforge.api.video.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
    List<Video> findByOwnerId(UUID ownerId);
}

