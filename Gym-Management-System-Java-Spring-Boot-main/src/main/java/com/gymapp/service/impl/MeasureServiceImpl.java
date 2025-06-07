package com.gymapp.service.impl;

import com.gymapp.dao.MeasureDao;
import com.gymapp.dao.UserDao;
import com.gymapp.domain.Measure;
import com.gymapp.domain.User;
import com.gymapp.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MeasureServiceImpl implements MeasureService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private MeasureDao measureDao;

    @Override
    @Transactional
    public Measure getMeasure(Long idMeasure) {
        return measureDao.findById(idMeasure).orElse(null);
    }

    @Override
    public void delete(Measure measure) {
       measureDao.delete(measure);
    }

    @Override
    public void save(Measure  measure) {
        measureDao.save(measure);
    }

    public Measure getUserMeasurements(User user) {
        return measureDao.findByUser(user);
    }

    public Measure getUserMeasurements(Long idUser) {
        Measure MeasuresUser = measureDao.findByIdUser(idUser);
        
        if (MeasuresUser == null) {
            MeasuresUser = new Measure();
            
            User user = userDao.findById(idUser).orElse(null);
            if (user != null) {
                MeasuresUser.setUser(user);
            }
        }
        
        return MeasuresUser;
    }
    
    @Override
    public void update(Measure measure, Long idUser) {
        if (measure.getUser() == null) {
            User user = userDao.findById(idUser).orElse(null);
            
            if (user != null) {
                measure.setUser(user);
            }
        }
        
        measureDao.save(measure);
    }

    @Override
    public void deleteById(Long idMeasure) {
        measureDao.deleteById(idMeasure);
    }
}
