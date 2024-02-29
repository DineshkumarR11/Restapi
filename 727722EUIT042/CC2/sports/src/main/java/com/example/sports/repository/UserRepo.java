package com.example.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sports.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
 
    User getUserByEmail(@Param("email") String email);

}