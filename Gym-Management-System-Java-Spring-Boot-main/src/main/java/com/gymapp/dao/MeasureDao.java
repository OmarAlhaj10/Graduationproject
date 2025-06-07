package com.gymapp.dao;

import com.gymapp.domain.Measure;
import com.gymapp.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface MeasureDao extends JpaRepositoryImplementation<Measure, Long> {

    Measure findByUser(User user);

    @Query("SELECT m FROM Measure m WHERE m.user.idUser = ?1")
    Measure findByIdUser(Long idUser);

    void deleteByUser(User user);

}
