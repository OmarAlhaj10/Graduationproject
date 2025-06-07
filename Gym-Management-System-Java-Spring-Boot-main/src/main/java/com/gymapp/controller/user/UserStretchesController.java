package com.gymapp.controller.user;

import com.gymapp.domain.Stretch;
import com.gymapp.service.StretchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserStretchesController {
    
    @Autowired
    private StretchService stretchService;
    
    @GetMapping("/stretches")
    public String userStretches(Model model) {
        List<Stretch> stretches = stretchService.getAll();
        model.addAttribute("stretches", stretches);
        
        return "user/stretches/stretches";
    }
    
    @GetMapping("/videos/{idStretch}")
    public String userStretching(@PathVariable Long idStretch, Model model) {
        Stretch stretch = stretchService.getStretchById(idStretch);
        model.addAttribute("stretch", stretch);
        
        return "user/stretches/videos";
    }
}

