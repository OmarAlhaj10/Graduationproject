package com.gymapp.service;

import com.gymapp.domain.Routine;
import com.gymapp.domain.User;
import java.util.List;

public interface RoutineService {

    public List<Routine> findRoutinesByUser(User user);
    
    public Routine findRoutine(Routine routine);
    
    public void saveRoutine(Routine routine);
    
    public void deleteRoutine(Routine routine);

}
