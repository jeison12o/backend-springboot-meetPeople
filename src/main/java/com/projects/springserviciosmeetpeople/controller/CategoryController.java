package com.projects.springserviciosmeetpeople.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springserviciosmeetpeople.document.Category;
import com.projects.springserviciosmeetpeople.service.CategoryService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category")
	public List<Category> all() {
		return categoryService.getAll();
	}
}
