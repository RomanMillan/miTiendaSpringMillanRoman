package com.jacaranda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String elementAdd(Model model){
		Element element = new Element();
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("newElement",element);
		model.addAttribute("categoryList",categoryList);
		return "elementAdd";
	}
	
	@PostMapping("/elementAddSubmit")
	public String elementAddSubmit(@ModelAttribute("newUser") Element element){
		elementService.save(element);
		return "elementAdded";
	}
	
	
//	borrar un elemento
	@GetMapping("/articulo/delete/{elementname}")
	public String elementDelete(Model model, @PathVariable("elementname") String elementname){
		Element element = elementService.getElement(elementname);
		try {
//			compruebo que existe el usuario, buscando un dato,
//			si este no existe saltará la excepción
			element.getElementname();
			model.addAttribute("deleteElement", element);
			return "elementDelete";			
		}catch (Exception e) {
			return "errorUser";
		}
	}
	
	@PostMapping("/elementDeleteSubmit")
	public String elementDeleteSubmit(@ModelAttribute("deleteElement") Element element){
		elementService.delete(element);
		return "elementDeleted";
	}
	
	
//	actualizar un elemento
	@GetMapping("/articulo/update/{elementname}")
	public String elementUpdate(Model model, @PathVariable("elementname") String elementname){
		Element element = elementService.getElement(elementname);
		model.addAttribute("updateElement",element);
		return "elementUpdate";
	}
	
	@PostMapping("/elementUpdateSubmit")
	public String elementUpdateSubmit(@ModelAttribute("updateCategory") Element element){
		elementService.save(element);
		return "elementUpdated";
	}
	
	
//	obtener todos los elementos
	@GetMapping("/articulo/list")
	public String elementList(Model model){
		List<Element> listElement = elementService.getElementList();
		model.addAttribute("listElement", listElement);
		return "elementList";
	}
}
