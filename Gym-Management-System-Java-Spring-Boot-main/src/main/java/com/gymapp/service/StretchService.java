package com.gymapp.service;

import com.gymapp.domain.Stretch;
import java.util.List;

public interface StretchService {
    
    public List<Stretch> getAll();
    
    public Stretch getStretchById(Long idStretch);
}
