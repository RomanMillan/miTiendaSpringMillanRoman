package com.jacaranda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.model.User;
import com.jacaranda.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
//	obtener lista de usuarios
	public List<User> getUserList() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
//	obtener usuario
	public User getUser(String username) {
		User user = userRepository.getReferenceById(username);
		return user;
	}
	
//	guardar usuario
	public boolean save(User user) {
		boolean success = false;
		User userSaved = userRepository.save(user);
		if(userSaved != null ) {
			success = true;
		}
		return success;
	}

	
//	borrar usuario
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
