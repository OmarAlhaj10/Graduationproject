package com.gymapp.service.impl;

import com.gymapp.dao.StretchDao;
import com.gymapp.domain.Stretch;
import com.gymapp.service.StretchService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StretchServiceImpl implements StretchService {

    @Autowired
    private StretchDao stretchDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Stretch> getAll() {
         return stretchDao.findAll();
    }

    @Override
    public Stretch getStretchById(Long idStretch) {
        Optional<Stretch> optionalStretch = stretchDao.findById(idStretch);
        return optionalStretch.orElse(null);
    }

}
