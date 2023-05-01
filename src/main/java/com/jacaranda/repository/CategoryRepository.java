package com.jacaranda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
