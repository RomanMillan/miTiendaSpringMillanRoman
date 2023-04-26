package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class UserController {
	@GetMapping("/user/add")
	public String userAdd(){
		return "userAdd";
	}
	
	@GetMapping("/user/delete")
	public String userDelete(Model model, @RequestParam("id")String id){
		return "userDelete";
	}
	
	@GetMapping("/user/update")
	public String userUpdate(Model model, @RequestParam("id")String id){
		return "userUpdate";
	}
	
	@GetMapping("/user/admin")
	public String userAdmin(Model model, @RequestParam("id")String id){
		return "userAdmin";
	}
	
	@GetMapping("/user/list")
	public String userList(){
		return "userList";
	}
}
