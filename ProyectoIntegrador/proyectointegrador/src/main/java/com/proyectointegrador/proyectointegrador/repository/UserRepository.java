package com.proyectointegrador.proyectointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectointegrador.proyectointegrador.model.User;

public interface UserRepository extends JpaRepository <User, Long> {

    User findUserByUsername (String username);
    
}
