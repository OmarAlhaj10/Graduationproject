package com.gymapp.controller.user;

import com.gymapp.domain.Measure;
import com.gymapp.service.MeasureService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserMeasuresController {

    @Autowired
    private HttpSession session;
    
    @Autowired
    private MeasureService measureService;
    

    @RequestMapping("/measures")
    public String UserMeasurements(Model model) {
        Long idUser = (Long) session.getAttribute("id");
        Measure userMeasures = measureService.getUserMeasurements(idUser);
        
        model.addAttribute("UserMeasures", userMeasures);
        
        return "user/measures/measures";

    }

    @PostMapping("/measures")
    public String measureSave(Measure userMeasure) {
        Long idUser = (Long) session.getAttribute("id");
        measureService.update(userMeasure, idUser);

        return "redirect:/user/measures";
    }
    
    
    @GetMapping("/measures/delete/{idMeasure}")
    public String deleteMeasure(Measure userMeasure) {
        measureService.deleteById(userMeasure.getIdMeasure());
        
        return "redirect:/user/measures";
    }
}