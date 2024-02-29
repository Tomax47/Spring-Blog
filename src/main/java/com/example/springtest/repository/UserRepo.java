package com.example.springtest.repository;

import com.example.springtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Model, Id>
public interface UserRepo extends JpaRepository<User, Long> {

}
