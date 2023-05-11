package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jacaranda.model.Category;
import com.jacaranda.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
//	obtener lista de categoria
	public Page<Category> getCategoryList(int numPage, int amountElements, String sortField, String searchField) {
		Pageable pageable = PageRequest.of(numPage -1, amountElements, Sort.by(sortField).ascending());
		if(searchField != null) {
			return categoryRepository.findByCategorynameLike("%"+ searchField + "%", pageable);
		}else {			
			return categoryRepository.findAll(pageable);
		}
		
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
