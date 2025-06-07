package com.gymapp.service.impl;

import com.gymapp.dao.*;
import com.gymapp.domain.ExerciseRoutine;
import com.gymapp.domain.Role;
import com.gymapp.domain.Routine;
import com.gymapp.domain.User;
import com.gymapp.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoutineDao routineDao;

    @Autowired
    ExerciseRoutineDao exerciseRoutineDao;
    
    @Autowired
    MeasureDao measureDao;

    @Override
    public List<User> findUserByUserRole(String nameRole) {
        List<User> users = userDao.findAllByRoleName(nameRole);
        return users;
    }

    @Override
    @Transactional
    public void deleteUser(Long idUser) {

        roleDao.deleteByIdUser(idUser);

        List<Routine> routines = routineDao.findByUser(userDao.findById(idUser).orElse(null));
        for (Routine routine : routines) {
            List<ExerciseRoutine> exercises = exerciseRoutineDao.findByRoutine(routine);
            if (!exercises.isEmpty()) {
                for (ExerciseRoutine ejercicio : exercises) {
                    exerciseRoutineDao.delete(ejercicio);
                }
            }
            routineDao.delete(routine);
        }

        measureDao.deleteByUser(userDao.findById(idUser).orElse(null));
        
        userDao.deleteById(idUser);
    }

    @Override
    public User findUserById(Long idUser) {
        return userDao.findById(idUser).orElse(null);
    }

    @Override
    public int save(User user) {

        if (userDao.findByUsername(user.getUsername()) != null
                || userDao.findByEmail(user.getEmail()) != null) {
            return 0;
        }

        var Code = new BCryptPasswordEncoder();
        user.setPassword(Code.encode(user.getPassword()));
        userDao.save(user);
        Role role = new Role();
        role.setIdUser(user.getIdUser());
        role.setName("ROLE_USER");
        roleDao.save(role);

        return 1;
    }
}
