package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerMain {
	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("mensaje", "Esto es un mensaje");
		return "index";
	}

	
}
