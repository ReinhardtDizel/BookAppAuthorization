package com.example.bookappauthorization.Controller;

import com.example.bookappauthorization.Model.User;
import com.example.bookappauthorization.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@RestController
@RequestMapping(value = "/login")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    User signUp(@RequestBody User user) {return userServiceImpl.save(user);}
}
