package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface EmployeeServiceDao extends Repository<EmployeeEntity, Long> {

    @Query("select e from EmployeeEntity e where e.idEmployee = :idEmployee")
    EmployeeEntity findEmployeeById(@Param("idEmployee") Long idEmployee);

    @Query("select e from EmployeeEntity e where e.active = 1")
    List<EmployeeEntity> findAllEmployees();
}
