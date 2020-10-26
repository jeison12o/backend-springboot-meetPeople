package com.projects.springserviciosmeetpeople.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springserviciosmeetpeople.document.User;
import com.projects.springserviciosmeetpeople.exception.NameUserNotRepeated;
import com.projects.springserviciosmeetpeople.exception.UserNotFound;
import com.projects.springserviciosmeetpeople.service.UserService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> all() {
		return userService.getAll();
	}
	
	@GetMapping("/user/likeName/{name}")
	public List<User> all(@PathVariable("name") String name) {
		return userService.getAllLikeName(name);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> oneId(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(userService.getOne(id));
		} catch (UserNotFound e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/user/nameUser/{NameUser}")
	public ResponseEntity<?> oneNameUser(@PathVariable("NameUser") String nameUser) {
		try {
			return ResponseEntity.ok(userService.getOneNameUser(nameUser));
		} catch (UserNotFound e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
			user = userService.save(user);
		} catch (NameUserNotRepeated e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody  User user) {
		try {
			user = userService.update(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> removeUser(@PathVariable("id") String id) {
		try {
			userService.delete(id);
		} catch (UserNotFound e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}
