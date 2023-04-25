package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/user/add")
	public String userAdd(){
		return "userAdd";
	}
	
	@GetMapping("/user/delete?id=user")
	public String userDelete(){
		return "userDelete";
	}
	
	@GetMapping("/user/update?id=user")
	public String userUpdate(){
		return "userUpdate";
	}
	
	@GetMapping("/user/admin?id=user")
	public String userAdmin(){
		return "userAdmin";
	}
	
	@GetMapping("/user/list")
	public String userList(){
		return "userList";
	}
}
