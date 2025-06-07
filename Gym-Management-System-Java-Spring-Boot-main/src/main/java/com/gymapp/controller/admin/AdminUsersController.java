package com.gymapp.controller.admin;

import com.gymapp.domain.User;
import com.gymapp.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminUsersController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String adminUsers(Model model) {

        List<User> user = userService.findUserByUserRole("ROLE_USER");
        
        model.addAttribute("user", user);

        return "admin/user/user";
    }
    
    // Handles the deletion of an object
    @GetMapping("/user/delete/{idUser}")
    public String deleteUsers(@PathVariable("idUser") Long idUser) {
       userService.deleteUser(idUser);
        return "redirect:/admin/user";
    }

}
