package com.tierra_de_estrellas.tierradeestrellas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tierra_de_estrellas.tierradeestrellas.model.User;

public interface UserRepository extends JpaRepository<User , Integer>{
    User findUserByUsername(String username);
}
