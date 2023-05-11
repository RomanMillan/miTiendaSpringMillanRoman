package com.jacaranda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
	public Page<Category> findByCategorynameLike(String keyword,Pageable pageable);
}
