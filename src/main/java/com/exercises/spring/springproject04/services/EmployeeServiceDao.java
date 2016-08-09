package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface EmployeeServiceDao extends Repository<EmployeeEntity, Long> {

    @Query("select e from EmployeeEntity e where e.idEmployee = :idEmployee")
    EmployeeEntity findEmployeeById(@Param("idEmployee") Long idEmployee);

    @Query("select e from EmployeeEntity e where e.active = 1 order by e.idEmployee")
    List<EmployeeEntity> findAllEmployees();

    @Query("select e from EmployeeEntity e where lower(concat(e.name, e.surname)) like lower(concat('%', :name,'%'))")
    List<EmployeeEntity> searchByName(@Param("name") String name);

    //void saveEmployee(EmployeeEntity employeeEntity);

    @Query(value = "select e from EmployeeEntity e", countQuery = "select count(e) from EmployeeEntity e")
    Page<EmployeeEntity> getPaginateEmployees(Pageable pageable);
 }
