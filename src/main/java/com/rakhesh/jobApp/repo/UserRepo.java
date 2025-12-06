package com.rakhesh.jobApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rakhesh.jobApp.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}