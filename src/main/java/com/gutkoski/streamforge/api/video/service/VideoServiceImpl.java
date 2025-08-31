package com.gutkoski.streamforge.api.video.service;

import com.gutkoski.streamforge.api.video.model.Video;
import com.gutkoski.streamforge.api.video.repository.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video uploadVideo(MultipartFile file, String title) {
        // TODO:  use MinIO as video storage
        Video video = new Video();
        video.setTitle(title);
        return videoRepository.save(video);
    }

    @Override
    public Video getVideoById(UUID id) {
        return videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Video not found"));
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
}
