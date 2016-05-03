package com.exercises.spring.springproject04.services;

import com.exercises.spring.springproject04.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginServiceDao extends JpaRepository<LoginEntity, Long> {

    @Query("SELECT l FROM LoginEntity l where l.username = :username")
    LoginEntity findLoginByUsername(@Param("username") String username);
}
