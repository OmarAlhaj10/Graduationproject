package com.gymapp.service.impl;

import com.gymapp.dao.ExerciseDao;
import com.gymapp.domain.Exercise;
import com.gymapp.service.ExerciseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseDao exerciseDao;

    @Override
    public List<Exercise> getExercises() {
        return exerciseDao.findAll();
    }

    @Override
    public Exercise getExerciseById(Exercise exercise) {
        return exerciseDao.findById(exercise.getIdExercise()).orElse(null);
    }

    @Override
    public void saveExercise(Exercise exercise) {
        exerciseDao.save(exercise);
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        exerciseDao.delete(exercise);
    }
}
