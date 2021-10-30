package com.example.bookappauthorization.Repositories;

import com.example.bookappauthorization.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findAllByUsername(String username);
}
