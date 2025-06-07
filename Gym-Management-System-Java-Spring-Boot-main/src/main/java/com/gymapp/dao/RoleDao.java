
package com.gymapp.dao;

import com.gymapp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDao extends JpaRepository<Role, Long> {
    
    public void deleteByIdUser(Long idUser);
    
}
