package com.example.bookappauthorization.Controller;

import com.example.bookappauthorization.Model.User;
import com.example.bookappauthorization.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }
    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) String userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.delete(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("findUserById", userService.findUserById(userId));
        return "admin";
    }
}
