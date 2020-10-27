package com.projects.springserviciosmeetpeople.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.springserviciosmeetpeople.document.Category;
import com.projects.springserviciosmeetpeople.repository.CategoryRepository;
import com.projects.springserviciosmeetpeople.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

}
