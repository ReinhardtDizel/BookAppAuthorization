package com.example.bookappauthorization.Controller;

import com.example.bookappauthorization.Model.User;
import com.example.bookappauthorization.Services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public User registration(Model model) {
        model.addAttribute("userForm", new User());
        System.out.println(new User());
        return new User();
    }

    @PostMapping()
    public void addUser(User user) {
        System.out.println(user);
    }
}
