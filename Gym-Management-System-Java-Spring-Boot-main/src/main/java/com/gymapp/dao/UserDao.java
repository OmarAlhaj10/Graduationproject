package com.gymapp.dao;

import com.gymapp.domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
    User findByEmail(String email);
    
    @Query(value = "SELECT DISTINCT u.* FROM gymapp.user u " +
            "INNER JOIN gymapp.role r ON u.id_user = r.id_user " +
            "WHERE r.name = :nameRole", nativeQuery = true)
    List<User> findAllByRoleName(@Param("nameRole") String nameRole);
    
}
