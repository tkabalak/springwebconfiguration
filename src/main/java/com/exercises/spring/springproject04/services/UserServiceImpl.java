package com.exercises.spring.springproject04.services;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserServiceImpl {

    @PersistenceContext
    private EntityManager em;


}
