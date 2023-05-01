package com.jacaranda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Category;
import com.jacaranda.model.Element;
import com.jacaranda.service.ElementService;

@Controller
public class ElementController {

	@Autowired
	ElementService elementService;
	
//	añadir un elemento
	@GetMapping("/element/add")
	public String elementAdd(Model model){
		Element element = new Element();
		model.addAttribute("newElement",element);
		return "elementAdd";
	}
	
	@PostMapping("/elementAddSubmit")
	public String elementAddSubmit(@ModelAttribute("newUser") Element element){
		elementService.save(element);
		return "elementAdded";
	}
	
	
//	borrar un elemento
	@GetMapping("/element/delete/{elementname}")
	public String elementDelete(Model model, @PathVariable("elementname") String elementname){
		Element element = elementService.getElement(elementname);
		elementService.delete(element);
		return "elementDelete";
	}
	
//	actualizar un elemento
	@GetMapping("/element/update/{elementname}")
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
	@GetMapping("/element/list")
	public String elementList(Model model){
		List<Element> listElement = elementService.getElementList();
		model.addAttribute("listElement", listElement);
		return "elementList";
	}
}
