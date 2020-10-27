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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springserviciosmeetpeople.document.ProfileComment;
import com.projects.springserviciosmeetpeople.service.ProfileCommentService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class ProfileCommentController {

	@Autowired
	private ProfileCommentService profileCommentService;
	
	@GetMapping("/profileComment")
	public List<ProfileComment> all() {
		return profileCommentService.getAll();
	}
	
	@GetMapping("/profileComment/idUserTo/{id}")
	public List<ProfileComment> allIdUserTo(@PathVariable("id") String id) {
		return profileCommentService.getAllUserTo(id);
	}
	
	@GetMapping("/profileComment/{id}")
	public ResponseEntity<?> oneId(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(profileCommentService.getOne(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/profileComment")
	public ResponseEntity<?> createComment(@RequestBody ProfileComment profileComment) {
		try {
			profileComment = profileCommentService.save(profileComment);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(profileComment);
	}
	
	@DeleteMapping("/profileComment/{id}")
	public ResponseEntity<?> removeComment(@PathVariable("id") String id) {
		try {
			profileCommentService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}
