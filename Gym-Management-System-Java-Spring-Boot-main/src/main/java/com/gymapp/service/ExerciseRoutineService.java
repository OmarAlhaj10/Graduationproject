package com.gymapp.service;

import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Routine;
import java.util.List;

public interface ExerciseRoutineService {

    public List<ExerciseRoutine> findExerciseRoutineByRoutine(Routine routine);

    public void RemoveExerciseRoutine(ExerciseRoutine exerciseRoutine);

    public void SaveExerciseRoutine(ExerciseRoutine exerciseRoutine);

}
