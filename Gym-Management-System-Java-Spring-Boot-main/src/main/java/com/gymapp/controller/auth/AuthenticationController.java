package com.gymapp.controller.auth;

import com.gymapp.domain.User;
import com.gymapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login(Model model) {
        return "/authentication/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "/authentication/registration";
    }

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(Model model, User user) {

        int state = userService.save(user);

        if (state == 0) {
            String message = "An error has occurred, the user name or email is already registered";
            model.addAttribute("message", message);
            return "/authentication/registration";
        } else {
            String message = "Successfully created user. "
                    + "Please log in with your credentials to get started.";
            model.addAttribute("message", message);
            return "/authentication/login";
        }

    }

}
