package com.example.bookappauthorization.Services.Interfaces;

import com.example.bookappauthorization.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    void delete(String id);
    Optional<User> getById(String id);
    List<User> getAll();
}
