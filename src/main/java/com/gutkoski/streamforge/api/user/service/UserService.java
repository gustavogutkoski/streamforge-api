package com.gutkoski.streamforge.api.user.service;

import com.gutkoski.streamforge.api.user.dto.UserResponseDTO;
import com.gutkoski.streamforge.api.user.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO createUser(User user);
    UserResponseDTO getUserById(UUID id);
    List<UserResponseDTO> getAllUsers();
}
