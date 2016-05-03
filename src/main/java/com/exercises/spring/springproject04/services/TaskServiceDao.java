package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskServiceDao extends JpaRepository<TaskEntity, Long> {

    @Modifying
    @Transactional
    @Query("update TaskEntity t set t.status = :status where t.idTask = :taskId")
    void updateStatus(@Param("taskId") Long taskId, @Param("status") short status);

}
