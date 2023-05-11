package com.jacaranda.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Category;
import com.jacaranda.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
//	añadir category 
	@GetMapping("/categoria/add")
	public String categoryAdd(Model model){
		Category category = new Category();
		model.addAttribute("newCategory",category);
		return "categoryAdd";
	}
	
	@PostMapping("/categoryAddSubmit")
	public String categoryAddSubmit(@ModelAttribute("newUser") Category category){
		Category categorycheck = categoryService.getCategory(category.getCategoryname());
		if(categorycheck == null) {
			categoryService.save(category);
			return "categoryAdded";			
		}else {
			return "errorCategoryAdd";
		}
	}
	
	
//	borrar category
	@GetMapping("/categoria/delete/{categoryname}")
	public String categoryDelete(Model model, @PathVariable("categoryname") String categoryname){
		Category category = categoryService.getCategory(categoryname);
		if(category != null) {
			model.addAttribute("deleteCategory", category);
			return "categoryDelete";			
		}else {
			return "errorCategory";
		}
	}
	
	@PostMapping("/categoryDeleteSubmit")
	public String categoryDeleteSubmit(@ModelAttribute("deleteCategory") Category category){
		categoryService.delete(category);
		return "categoryDeleted";
	}
	
	
	
//	actualizar category
	@GetMapping("/categoria/update/{categoryname}")
	public String categoryUpdate(Model model, @PathVariable("categoryname") String categoryname){
		Category category = categoryService.getCategory(categoryname);
		if(category != null) {
			model.addAttribute("updateCategory",category);
			return "categoryUpdate";			
		}else {
			return "errorCategory";
		}
	}
	
	@PostMapping("/categoryUpdateSubmit")
	public String categoryUpdateSubmit(@ModelAttribute("updateCategory") Category category){
		categoryService.save(category);
		return "categoryUpdated";
	}
	
	
//	mostrar lista de categorias
	@GetMapping("/categoria/list")
	public String categoryList(Model model, @RequestParam Optional<Integer> numPage, @RequestParam Optional<Integer> amountElements, @RequestParam Optional<String>sortField, @RequestParam Optional<String> searchField){
		Page<Category> listCategory = categoryService.getCategoryList(numPage.orElse(1),amountElements.orElse(10), sortField.orElse("categoryname"), searchField.orElse(null));
		model.addAttribute("currentPage",numPage.orElse(1));
		model.addAttribute("totalPages",listCategory.getTotalPages());
		model.addAttribute("totalItems",listCategory.getTotalElements());
		model.addAttribute("listElement", listCategory.getContent());
		model.addAttribute("listCategory", listCategory);
		return "categoryList";
	}
}
