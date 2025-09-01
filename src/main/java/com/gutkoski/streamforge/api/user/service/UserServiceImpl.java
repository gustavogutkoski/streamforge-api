package com.gutkoski.streamforge.api.user.service;

import com.gutkoski.streamforge.api.user.dto.UserRequestDTO;
import com.gutkoski.streamforge.api.user.dto.UserResponseDTO;
import com.gutkoski.streamforge.api.user.mapper.UserMapper;
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
    public UserResponseDTO createUser(UserRequestDTO request) {
        User savedUser = userRepository.save(
                UserMapper.INSTANCE.toEntity(request)
        );
        return UserMapper.INSTANCE.toDTO(savedUser);
    }

    private String hashPassword(String password) {
        // TODO: use BCryptPasswordEncoder?
        return password;
    }

    @Override
    public UserResponseDTO getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.toDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
