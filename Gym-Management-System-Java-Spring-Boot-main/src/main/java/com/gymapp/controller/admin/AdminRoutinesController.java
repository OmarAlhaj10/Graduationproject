package com.gymapp.controller.admin;

import com.gymapp.domain.Exercise;
import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Routine;
import com.gymapp.domain.User;
import com.gymapp.service.ExerciseRoutineService;
import com.gymapp.service.ExerciseService;
import com.gymapp.service.RoutineService;
import com.gymapp.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminRoutinesController {

    @Autowired
    UserService userService;

    @GetMapping("/routines")
    public String adminListUsersRoutines(Model model) {
        List<User> user = userService.findUserByUserRole("ROLE_USER");
        model.addAttribute("user", user);
        return "admin/routines/routines";
    }

    @Autowired
    RoutineService routineService;

    @Autowired
    ExerciseRoutineService exerciseRoutineService;

    @GetMapping("/routines/user/{idUser}")
    public String routinesAdminListUserRoutines(Model model, User user) {
        List<Routine> routine = routineService.findRoutinesByUser(user);
        model.addAttribute("routine", routine);
        model.addAttribute("idUser", user.getIdUser());
        return "admin/routines/routines-user";
    }

    @GetMapping("/routines/user/routine/{idRoutine}")
    public String routinesAdminRoutine(Model model, Routine routine) {
        routine = routineService.findRoutine(routine);
        List<ExerciseRoutine> exercise = exerciseRoutineService.findExerciseRoutineByRoutine(routine);
        model.addAttribute("exercise", exercise);
        model.addAttribute("routine", routine);
        return "admin/routines/routines-user-routine";
    }

    @GetMapping("/routines/user/routine/{idRoutine}/delete/{idExerciseRoutine}")
    public String routinesAdminDeleteExerciseRoutine(@PathVariable("idRoutine") Long idRoutine,
            ExerciseRoutine exerciseRoutine) {
        exerciseRoutineService.RemoveExerciseRoutine(exerciseRoutine);
        return "redirect:/admin/routines/user/routine/" + idRoutine;
    }

    @PostMapping("/routines/user/routine/{idRoutine}/update/{idExerciseRoutine}")
    public String routinesAdminSaveExerciseRoutine(@PathVariable("idRoutine") Long idRoutine, ExerciseRoutine exerciseRoutine) {
        exerciseRoutineService.SaveExerciseRoutine(exerciseRoutine);
        return "redirect:/admin/routines/user/routine/" + idRoutine;
    }

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/routines/user/routine/{idRoutine}/add/")
    public String routinesAdminListExercisestoAdd(Model model, @PathVariable("idRoutine") Long idRoutine) {
        List<Exercise> exercise = exerciseService.getExercises();
        model.addAttribute("listExercises", exercise);
        model.addAttribute("idRoutine", idRoutine);
        return "admin/routines/routines-user-routine-add";
    }

    @GetMapping("/routines/user/routine/{idRoutine}/add/{idExercise}")
    public String routinesAdminAddExerciseRoutine(Routine routine, Exercise exercise, ExerciseRoutine exerciseRoutine) {
        exercise = exerciseService.getExerciseById(exercise);
        routine = routineService.findRoutine(routine);
        exerciseRoutine.setRoutine(routine);
        exerciseRoutine.setExercise(exercise);
        exerciseRoutine.setCurrentWeight(0.0d);
        exerciseRoutine.setPreviousWeight(0.0d);
        exerciseRoutineService.SaveExerciseRoutine(exerciseRoutine);
        return "redirect:/admin/routines/user/routine/" + routine.getIdRoutine();
    }

    @PostMapping("/routines/user/routine/{idUser}/add/")
    public String routinesAdminAddNewRoutine(User user, Routine routine) {
        routine.setUser(user);
        routineService.saveRoutine(routine);
        return "redirect:/admin/routines/user/" + user.getIdUser();
    }

    @GetMapping("/routines/user/{idUser}/routine/{idRoutine}/delete")
    public String routinesAdminDeleteRoutine(Routine routine, User user) {
        routineService.deleteRoutine(routine);
        return "redirect:/admin/routines/user/" + user.getIdUser();
    }
}
