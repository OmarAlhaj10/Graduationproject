package com.gymapp.controller.admin;

import com.gymapp.domain.Exercise;
import com.gymapp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class ExercisesAdminController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/exercises")
    public String exercisesAdmin(Model model) {
        List<Exercise> exercise = exerciseService.getExercises();
        model.addAttribute("exercise", exercise);
        return "admin/exercises/exercises";
    }

    @PostMapping("/exercises/add")
    public String saveExercise(Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return "redirect:/admin/exercises";
    }

    @PostMapping("/exercises/edit/{idExercise}")
    public String modifyExercise(Exercise exercise) {
        exerciseService.saveExercise(exercise);
        return "/admin/exercises/exercises-modify";
    }
    
    @GetMapping("/exercises/edit/{idExercise}")
    public String modifyExercises(Exercise exercise, Model model) {
       exercise = exerciseService.getExerciseById(exercise);
       model.addAttribute("exercise", exercise);
        return "/admin/exercises/exercises-modify";
    }

    @GetMapping("/exercises/delete/{idExercise}")
    public String deleteExercise(Exercise exercise) {
         exerciseService.deleteExercise(exercise);
        return "redirect:/admin/exercises";
    }
}
