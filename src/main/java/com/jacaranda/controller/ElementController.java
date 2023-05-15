package com.jacaranda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Category;
import com.jacaranda.model.Element;
import com.jacaranda.model.User;
import com.jacaranda.service.CategoryService;
import com.jacaranda.service.ElementService;

@Controller
public class ElementController {

	@Autowired
	ElementService elementService;
	@Autowired
	CategoryService categoryService;
	
//	añadir un elemento
	@GetMapping("/articulo/add")
	public String elementAdd(Model model, 
			@RequestParam Optional<Integer> numPage, 
			@RequestParam Optional<Integer> amountElements, 
			@RequestParam Optional<String>sortField,
			@RequestParam Optional<String> searchField){
		Element element = new Element();
		Page<Category> categoryList = categoryService.getCategoryList(numPage.orElse(1),
				amountElements.orElse(10), 
				sortField.orElse("categoryname"),
				searchField.orElse(null));
		model.addAttribute("newElement",element);
		model.addAttribute("categoryList",categoryList);
		return "elementAdd";
	}
	
	@PostMapping("/elementAddSubmit")
	public String elementAddSubmit(@ModelAttribute("newUser") Element element){
			Element elementCheck = elementService.getElement(element.getElementname());
		if(elementCheck == null) {
			elementService.save(element);
			return "elementAdded";			
		}else {
			return "errorElementAdd";
		}
	}
	
	
//	borrar un elemento
	@GetMapping("/articulo/delete/{elementname}")
	public String elementDelete(Model model, @PathVariable("elementname") String elementname){
		Element element = elementService.getElement(elementname);
		if(element.getElementname() != null) {
			model.addAttribute("deleteElement", element);
			return "elementDelete";			
		}else {
			return "errorElement";
		}
	}
	
	@PostMapping("/elementDeleteSubmit")
	public String elementDeleteSubmit(@ModelAttribute("deleteElement") Element element){
		elementService.delete(element);
		return "elementDeleted";
	}
	
	
//	actualizar un elemento
	@GetMapping("/articulo/update/{elementname}")
	public String elementUpdate(Model model, 
			@PathVariable("elementname") String elementname, 
			@RequestParam Optional<Integer> numPage, 
			@RequestParam Optional<Integer> amountElements, 
			@RequestParam Optional<String>sortField,
			@RequestParam Optional<String> searchField){
		Element element = elementService.getElement(elementname);
		if(element != null) {
			Page<Category> categoryList = categoryService.getCategoryList(numPage.orElse(1),
					amountElements.orElse(10), 
					sortField.orElse("categoryname"), 
					searchField.orElse(null));
			model.addAttribute("updateElement",element);
			model.addAttribute("categoryList",categoryList);
			return "elementUpdate";			
		}else {
			return "errorElement";
		}
	}
	
	@PostMapping("/elementUpdateSubmit")
	public String elementUpdateSubmit(@ModelAttribute("updateCategory") Element element){
		elementService.save(element);
		return "elementUpdated";
	}
	
	
//	obtener todos los elementos
	@GetMapping("/articulo/list")
	public String elementList(
				Model model, 
				@RequestParam Optional<Integer> numPage, 
				@RequestParam Optional<Integer> amountElements, 
				@RequestParam Optional<String>sortField, 
				@RequestParam Optional<String> searchField,
				@RequestParam Optional<String> categoria
				){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Page<Element> listElement;
		if (categoria.isPresent()) {
			listElement = elementService.getElementList(
					numPage.orElse(1),
					amountElements.orElse(10), 
					sortField.orElse("elementname"), 
					searchField.orElse(null),
					null);	
		}else {
			listElement = elementService.getElementList(
					numPage.orElse(1),
					amountElements.orElse(10), 
					sortField.orElse("elementname"), 
					searchField.orElse(null), 
					categoria.orElse(null));
		}
		
		model.addAttribute("currentPage",numPage.orElse(1));
		model.addAttribute("totalPages",listElement.getTotalPages());
		model.addAttribute("totalItems",listElement.getTotalElements());
		model.addAttribute("listElement", listElement.getContent());
		model.addAttribute("user",user);
		return "elementList";
	}
}
