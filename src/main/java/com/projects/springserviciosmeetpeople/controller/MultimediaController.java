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

import com.projects.springserviciosmeetpeople.document.Multimedia;
import com.projects.springserviciosmeetpeople.dto.MultimediaRequest;
import com.projects.springserviciosmeetpeople.service.MultimediaService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class MultimediaController {

	@Autowired
	private MultimediaService multimediaService;
	
	@GetMapping("/multimedia")
	public List<Multimedia> all() {
		return multimediaService.getAll();
	}
	
	@GetMapping("/multimedia/userToAndType")
	public List<Multimedia> allIduserToAndType(@RequestBody MultimediaRequest multimedia) {
		return multimediaService.getAllIduserToAndType(multimedia.get_iduserTo(), multimedia.getType());
	}
	
	@GetMapping("/multimedia/userToAndTypeAndCategory")
	public List<Multimedia> allIduserToAndTypeAndCategory(@RequestBody MultimediaRequest multimedia) {
		return multimediaService.getAllIduserToAndTypeAndCategory(multimedia.get_iduserTo(), multimedia.getType(), multimedia.getCategory());
	}
	
	@GetMapping("/multimedia/{id}")
	public ResponseEntity<?> oneId(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(multimediaService.getOne(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping("/multimedia")
	public ResponseEntity<?> createMultimedia(@RequestBody MultimediaRequest multimedia) {
		Multimedia m = null;
		try {
			m = multimediaService.save(multimedia);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return  ResponseEntity.status(HttpStatus.CREATED).body(m);
	}
	
	@DeleteMapping("/multimedia/{id}")
	public ResponseEntity<?> removeMultimedia(@PathVariable("id") String id) {
		try {
			multimediaService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.ok().build();
	}
}