package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElementController {

	@GetMapping("/element/add")
	public String elementAdd(){
		return "elementAdd";
	}
	
	@GetMapping("/element/delete?id=element")
	public String elementDelete(){
		return "elementDelete";
	}
	
	@GetMapping("/element/update?id=element")
	public String elementUpdate(){
		return "elementUpdate";
	}
	
	@GetMapping("/element/list")
	public String elementList(){
		return "elementList";
	}
}
