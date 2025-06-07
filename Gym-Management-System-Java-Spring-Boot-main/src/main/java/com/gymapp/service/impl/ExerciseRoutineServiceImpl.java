package com.gymapp.service.impl;

import com.gymapp.dao.ExerciseRoutineDao;
import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Routine;
import com.gymapp.service.ExerciseRoutineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseRoutineServiceImpl implements ExerciseRoutineService {

    @Autowired
    ExerciseRoutineDao exerciseRoutineDao;

    @Override
    public List<ExerciseRoutine> findExerciseRoutineByRoutine(Routine routine) {
        List<ExerciseRoutine> ejercicios = exerciseRoutineDao.findByRoutine(routine);
        return ejercicios;
    }

    @Override
    public void RemoveExerciseRoutine(ExerciseRoutine exerciseRoutine) {
        exerciseRoutineDao.delete(exerciseRoutine);
    }

    @Override
    public void SaveExerciseRoutine(ExerciseRoutine exerciseRoutine) {
        exerciseRoutineDao.save(exerciseRoutine);
    }

}
