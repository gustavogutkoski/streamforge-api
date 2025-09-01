package com.gutkoski.streamforge.api.user.service;

import com.gutkoski.streamforge.api.user.dto.UserRequestDTO;
import com.gutkoski.streamforge.api.user.dto.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO getUserById(UUID id);
    List<UserResponseDTO> getAllUsers();
}
