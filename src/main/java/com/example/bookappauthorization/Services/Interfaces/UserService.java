package com.example.bookappauthorization.Services.Interfaces;

import com.example.bookappauthorization.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    void delete(String id);
    User findUserById(String id);
    List<User> allUsers();
}
