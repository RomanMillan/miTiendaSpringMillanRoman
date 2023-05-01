package com.jacaranda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
