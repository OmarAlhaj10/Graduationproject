package com.gymapp.service;

import com.gymapp.domain.Exercise;

import java.util.List;

public interface ExerciseService {

    public List<Exercise> getExercises();

    public Exercise getExerciseById(Exercise exercise);

    public void saveExercise(Exercise exercise);

    public void deleteExercise(Exercise exercise);
}
