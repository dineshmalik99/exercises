package com.dinesh.restservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dinesh.restservice.user.User;
import com.dinesh.restservice.user.UserDao;
import com.dinesh.restservice.user.exception.UserNotFoundException;

@RestController
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired
	UserDao userService;
	
	@GetMapping()
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	@GetMapping(path="/{id}")
	public User getUser(@PathVariable int id){
		User user = userService.getUser(id);
		if(user==null){
			throw new UserNotFoundException("user-id not found : "+id);
		}
		return user;
	}
	
	
	@GetMapping(path="/user/{name}")
	public User getUser( @PathVariable String name){
		return userService.getUserbyName(name);
	}
	
	@PostMapping
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
		 user = userService.saveUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		User user = userService.deleteUser(id);
		if(user==null){
			throw new UserNotFoundException("user-id not found : "+id);
		}
		return ResponseEntity.ok(user);
	}
}
