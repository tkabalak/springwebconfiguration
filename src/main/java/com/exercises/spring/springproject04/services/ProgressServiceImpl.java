package com.exercises.spring.springproject04.services;


import com.exercises.spring.springproject04.entities.ProgressEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProgressServiceImpl {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(ProgressEntity progressEntity){
        em.persist(progressEntity);
    }
}
