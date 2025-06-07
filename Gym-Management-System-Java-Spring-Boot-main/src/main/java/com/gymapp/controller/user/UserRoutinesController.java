package com.gymapp.controller.user;

import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Routine;
import com.gymapp.domain.User;
import com.gymapp.service.ExerciseRoutineService;
import com.gymapp.service.RoutineService;
import com.gymapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserRoutinesController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoutineService routineService;

    @Autowired
    private ExerciseRoutineService exerciseRoutineService;

    @GetMapping("/routines")
    public String routinesUser(Model model, HttpSession session) {

        Long idUser = (Long) session.getAttribute("id");
        User user = userService.findUserById(idUser);
        List<Routine> routine = routineService.findRoutinesByUser(user);

        model.addAttribute("routine", routine);
        model.addAttribute("idUser", idUser);
        return "user/routines/routines";
    }

    @GetMapping("/routines/routine/{idRoutine}")
    public String routinesUserRoutine(Model model, Routine routine) {

        routine = routineService.findRoutine(routine);
        List<ExerciseRoutine> exercise = exerciseRoutineService.findExerciseRoutineByRoutine(routine);
        model.addAttribute("routine", routine);
        model.addAttribute("exercise", exercise);

        return "user/routines/routine";
    }

    @PostMapping("/routines/routine/{idRoutine}/update/{idExerciseRoutine}")
    public String routinesUserExerciseSave(@PathVariable("idRoutine") Long idRoutine, ExerciseRoutine exerciseRoutine) {

        exerciseRoutineService.SaveExerciseRoutine(exerciseRoutine);
        return "redirect:/user/routines/routine/{idRoutine}";
    }

}
