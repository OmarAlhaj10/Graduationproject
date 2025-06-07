package com.gymapp.dao;

import com.gymapp.domain.Routine;
import com.gymapp.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface RoutineDao extends JpaRepositoryImplementation<Routine, Long> {

    List<Routine> findByUser(User user);

}
