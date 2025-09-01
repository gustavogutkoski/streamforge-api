package com.gutkoski.streamforge.api.user.service;

import com.gutkoski.streamforge.api.user.dto.UserResponseDTO;
import com.gutkoski.streamforge.api.user.model.User;
import com.gutkoski.streamforge.api.user.repository.UserRepository;
import com.gutkoski.streamforge.api.video.dto.VideoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        return toDTO(savedUser);
    }

    @Override
    public UserResponseDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private UserResponseDTO toDTO(User user) {
        List<VideoResponseDTO> videos = user.getVideos().stream()
                .map(video -> new VideoResponseDTO(
                        video.getId(),
                        video.getTitle(),
                        video.getDescription(),
                        video.getOwner().getId()
                ))
                .toList();

        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                videos
        );
    }
}
