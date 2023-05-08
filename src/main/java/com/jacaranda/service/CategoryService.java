package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Category;
import com.jacaranda.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
//	obtener lista de categoria
	public List<Category> getCategoryList() {
		List<Category> categoryList = categoryRepository.findAll();
		return categoryList;
	}
	
//	obtener categoria
	public Category getCategory(String categoryname) {
		Category category = categoryRepository.findById(categoryname).orElse(null);
		return category;
	}
	
//	guardar categoria
	public boolean save(Category category) {
		boolean success = false;
		Category categorySaved = categoryRepository.save(category);
		if(categorySaved != null) {
			success = true;
		}
		return success;
	}
	
//	borrar categoria
	public void delete(Category category) {
		categoryRepository.delete(category);
	}
	
}
