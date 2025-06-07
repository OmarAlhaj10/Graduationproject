package com.gymapp.service;

import com.gymapp.domain.Measure;
import com.gymapp.domain.User;


public interface MeasureService {

    public Measure getMeasure(Long idMeasure);
    
    public Measure getUserMeasurements(User user);
    
    public Measure getUserMeasurements(Long idUser);

    void delete(Measure Measure);

    void save(Measure Measure);
    
    void update(Measure Measure, Long idUser);
    
    void deleteById(Long idMeasure);

}
