package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.TaskEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl {

    @PersistenceContext
    private EntityManager em;

    public List<TaskEntity> findAllTask(){
        return em.createQuery("SELECT t FROM TaskEntity t", TaskEntity.class).getResultList();
    }

    public List<TaskEntity> findAllTaskForUser(Long userID){
        TypedQuery<TaskEntity> query = em.createQuery("SELECT t FROM TaskEntity t WHERE t.active = :active and t.ownerId = :userId", TaskEntity.class);
        query.setParameter("active", (long) 1);
        query.setParameter("userId", userID);
        List<TaskEntity> resultList = query.getResultList();
        return resultList;
    }

    public Optional<TaskEntity> findTask(Long taskId){
        TypedQuery<TaskEntity> query = em.createQuery("SELECT t FROM TaskEntity t WHERE t.active = :active and t.idTask = :taskId", TaskEntity.class);
        query.setParameter("active", (long) 1);
        query.setParameter("taskId", taskId);
        List<TaskEntity> resultList = query.getResultList();
        return Optional.ofNullable(resultList.get(0));
    }



    @Transactional
    public void save(TaskEntity taskEntity){
        em.persist(taskEntity);
    }
}
