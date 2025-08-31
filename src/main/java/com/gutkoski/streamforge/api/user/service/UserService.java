package com.gutkoski.streamforge.api.user.service;

import com.gutkoski.streamforge.api.user.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(User user);
    User getUserById(UUID id);
    List<User> getAllUsers();
}
