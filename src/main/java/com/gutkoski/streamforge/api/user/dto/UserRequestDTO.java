package com.gutkoski.streamforge.api.user.dto;

public record UserRequestDTO(
        String username,
        String email,
        String passwordHash
) {}
