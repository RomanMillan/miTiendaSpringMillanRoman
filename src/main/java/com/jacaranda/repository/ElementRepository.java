package com.jacaranda.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.model.Category;
import com.jacaranda.model.Element;

public interface ElementRepository extends JpaRepository<Element, String> {
	public Page<Element> findByElementnameLike(String keyword,Pageable pageable);
	
	public Page<Element> findByCategoryAndSearchField(Category categoryId, String keyword, Pageable pageable);
	
	public Page<Element> findByCategory(Category categoryId, Pageable pageable);
}
