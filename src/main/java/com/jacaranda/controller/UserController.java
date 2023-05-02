package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.model.User;
import com.jacaranda.service.UserService;

import java.util.List;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	añadir usuario 
	@GetMapping("/user/add")
	public String userAdd(Model model){
		User user = new User();
		model.addAttribute("newUser",user);
		return "userAdd";
	}
	
	@PostMapping("/userAddSubmit")
	public String userAddSubmit(@ModelAttribute("newUser") User user){
		userService.save(user);
		return "userAdded";
	}
	
	
//	borrar usuario
	@GetMapping("/user/delete/{username}")
	public String userDelete(Model model, @PathVariable("username") String username){
		User user = userService.getUser(username);
		userService.delete(user);
		return "userDelete";
	}
	
//	actualizar usuario
	@GetMapping("/user/update/{username}")
	public String userUpdate(Model model, @PathVariable("username") String username){
		User user = userService.getUser(username);
		model.addAttribute("updateUser",user);
		return "userUpdate";
	}
	
	@PostMapping("/userUpdateSubmit")
	public String userUpdateSubmit(@ModelAttribute("updateUser") User user){
		userService.save(user);
		return "userUpdated";
	}
	
//	mostar usuario 
	@GetMapping("/user/admin/{username}")
	public String userAdmin(Model model, @PathVariable("username") String username){
		User user = userService.getUser(username);
		model.addAttribute("user",user);
		return "userAdmin";
	}
	
//	mostrar lista de usuarios
	@GetMapping("/user/list")
	public String userList(Model model){
		List<User> listUser = userService.getUserList();
		model.addAttribute("listUser", listUser);
		return "userList";
	}


	//hacer login
	@GetMapping("/")
	public String isValid(Model model){
		User userLogin = new User();
		model.addAttribute("userLogin",userLogin);
		return "index";
	}

}
