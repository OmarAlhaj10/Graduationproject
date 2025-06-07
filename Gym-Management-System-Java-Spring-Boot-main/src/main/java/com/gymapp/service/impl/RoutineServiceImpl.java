package com.gymapp.service.impl;

import com.gymapp.dao.ExerciseRoutineDao;
import com.gymapp.dao.RoutineDao;
import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Routine;
import com.gymapp.domain.User;
import com.gymapp.service.RoutineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineServiceImpl implements RoutineService {

    @Autowired
    RoutineDao routineDao;
    
    @Override
    public List<Routine> findRoutinesByUser(User user) {
        List<Routine> routines = routineDao.findByUser(user);
        return routines;
    }

    @Override
    public Routine findRoutine(Routine routine) {
        return routineDao.findById(routine.getIdRoutine()).orElse(null);
    }

    @Override
    public void saveRoutine(Routine routine) {
        routineDao.save(routine);
    }
    
    @Autowired
    ExerciseRoutineDao exerciseRoutineDao;

    @Override
    public void deleteRoutine(Routine routine) {
        
        List<ExerciseRoutine> exercises = exerciseRoutineDao.findByRoutine(routine);
        if (!exercises.isEmpty()) {
            for (ExerciseRoutine exercise : exercises) {
                exerciseRoutineDao.delete(exercise);
            }
        }
        
        routineDao.delete(routine);
        
    }

}
