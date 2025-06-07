package com.gymapp.service;

import com.gymapp.domain.User;
import java.util.List;

public interface UserService {

    public List<User> findUserByUserRole(String nameRole);

    public void deleteUser(Long idUser);

    public User findUserById(Long idUser);
    
    public int save(User user);
}
