package com.projects.springserviciosmeetpeople.service;

import java.util.List;

import com.projects.springserviciosmeetpeople.document.Multimedia;

public interface MultimediaService {
	Multimedia save(Multimedia multimedia);
	void delete(String _id);
	Multimedia getOne(String _id);
	List<Multimedia> getAll();
	List<Multimedia> getAllIduserToAndType(String _iduserTo, String type);
	List<Multimedia> getAllIduserToAndTypeAndCategory(String _iduserTo, String type, String category); 
}
