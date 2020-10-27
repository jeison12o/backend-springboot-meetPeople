package com.projects.springserviciosmeetpeople.service;

import java.util.List;

import com.projects.springserviciosmeetpeople.document.Multimedia;
import com.projects.springserviciosmeetpeople.dto.MultimediaRequest;

public interface MultimediaService {
	Multimedia save(MultimediaRequest multimedia);
	void delete(String _id);
	Multimedia getOne(String _id);
	List<Multimedia> getAll();
	List<Multimedia> getAllIduserToAndType(String _iduserTo, String type);
	List<Multimedia> getAllIduserToAndTypeAndCategory(String _iduserTo, String type, String category); 
}
