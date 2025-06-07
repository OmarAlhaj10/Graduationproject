
package com.gymapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("id");
        model.addAttribute("userId", userId);

        return "/index";
    }

}
