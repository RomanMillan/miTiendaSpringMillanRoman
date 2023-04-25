package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Category {

	@GetMapping("/category/add")
	public String categoryAdd(){
		return "categoryAdd";
	}
	
	@GetMapping("/category/delete?id=category")
	public String categoryDelete(){
		return "categoryDelete";
	}
	
	@GetMapping("/category/update?id=category")
	public String categoryUpdate(){
		return "categoryUpdate";
	}
	
	@GetMapping("/category/list")
	public String categoryList(){
		return "categoryList";
	}
}
