package com.jacaranda.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.model.User;
import com.jacaranda.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
//	obtener lista de usuarios
	public List<User> getUserList() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
//	obtener usuario
	public User getUser(String username) {
		User user = userRepository.findById(username).orElse(null);
		return user;
	}
	
//	guardar usuario
	public boolean save(User user) {
		boolean success = false;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
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

//	modificar el campo admin
	public void changeAdmin(User user) {
		if(user.isAdministrator()) {			
			user.setAdministrator(false);
		}else {
			user.setAdministrator(true);
		}
	}
	
//	metodo implementado del UserDetailsService
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).orElse(null);
		if(user == null) {
			throw new UsernameNotFoundException("Usuario no existe en la BD");
		}else {			
			return user;
		}
	}

	
}
