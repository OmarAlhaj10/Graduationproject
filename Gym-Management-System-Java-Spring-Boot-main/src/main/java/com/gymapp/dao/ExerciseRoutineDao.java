package com.gymapp.dao;

import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Routine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRoutineDao extends JpaRepository<ExerciseRoutine, Long> {

    List<ExerciseRoutine> findByRoutine(Routine routine);

}
