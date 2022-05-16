package com.example.crud.repository;

import java.util.Optional;

import com.example.crud.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

  Optional<User> findById(Integer id);
  
  
}
