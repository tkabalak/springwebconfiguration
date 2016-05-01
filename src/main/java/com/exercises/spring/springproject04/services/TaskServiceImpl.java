package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.TaskEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl {

    @PersistenceContext
    private EntityManager em;

    public List<TaskEntity> findAllTask(){
        return em.createQuery("SELECT t FROM TaskEntity t", TaskEntity.class).getResultList();
    }

    public List<TaskEntity> findAllTaskForUser(Long userID){
        TypedQuery<TaskEntity> query = em.createQuery("SELECT t FROM TaskEntity t " +
                "WHERE t.active = :active and t.ownerId = :userId", TaskEntity.class);
        query.setParameter("active", (long) 1);
        query.setParameter("userId", userID);
        List<TaskEntity> resultList = query.getResultList();
        return resultList;
    }

    public Optional<TaskEntity> findTask(Long taskId){
        TypedQuery<TaskEntity> query = em.createQuery("SELECT t FROM TaskEntity t " +
                "WHERE t.active = :active and t.idTask = :taskId", TaskEntity.class);
        query.setParameter("active", (long) 1);
        query.setParameter("taskId", taskId);
        List<TaskEntity> resultList = query.getResultList();
        return Optional.ofNullable(resultList.get(0));
    }

//    public List<TaskEntity> findAllTaskGivenByManager(Long managerId){
//        TypedQuery<TaskEntity> query = em.createQuery("SELECT t FROM TaskEntity t " +
//                "WHERE t.active = :active and t.managerId = :managerId", TaskEntity.class);
//        query.setParameter("active", (long) 1);
//        query.setParameter("managerId", managerId);
//        List<TaskEntity> resultList = query.getResultList();
//        return resultList;
//    }
//
//    public List<List<TaskEntity>> findAllTaskGivenByManagerSorted(Long managerId){
//        List<TaskEntity> tasks = findAllTaskGivenByManager(managerId);
//        List<List<TaskEntity>> result = getEmployeesIdWithManagerTask(managerId).stream()
//                .map(e -> getEmployeTaskFromManager(e, tasks))
//                .collect(Collectors.toCollection(ArrayList::new));
//        return result;
//    }
//
//    public List<TaskEntity> getEmployeTaskFromManager(Long ownerId, List<TaskEntity> tasks){
//        return tasks.stream()
//                .filter(e -> ownerId.equals(e.getOwnerId()))
//                .collect(Collectors.toCollection(ArrayList::new));
//    }
//    public List<Long> getEmployeesIdWithManagerTask(Long managerId){
//        TypedQuery<Long> query = em.createQuery("SELECT DISTINCT t.ownerId FROM TaskEntity t " +
//                "WHERE t.active = :active and t.managerId = :managerId", Long.class);
//        query.setParameter("active", (long) 1);
//        query.setParameter("managerId", managerId);
//        return query.getResultList();
//    }

    @Transactional
    public void save(TaskEntity taskEntity){
        em.persist(taskEntity);
    }
}
