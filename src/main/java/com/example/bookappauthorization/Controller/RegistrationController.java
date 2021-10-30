package com.example.bookappauthorization.Controller;

import com.example.bookappauthorization.Model.User;
import com.example.bookappauthorization.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public void addUser(User user) {
        System.out.println(user);
    }
}
