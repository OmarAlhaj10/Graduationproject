package com.gymapp.dao;

import com.gymapp.domain.Exercise;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ExerciseDao extends JpaRepositoryImplementation<Exercise, Long> {

}
