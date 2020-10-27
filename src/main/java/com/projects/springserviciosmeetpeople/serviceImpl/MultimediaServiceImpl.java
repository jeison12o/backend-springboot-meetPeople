package com.projects.springserviciosmeetpeople.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projects.springserviciosmeetpeople.document.Multimedia;
import com.projects.springserviciosmeetpeople.repository.MultimediaRepository;
import com.projects.springserviciosmeetpeople.service.MultimediaService;

@Repository
public class MultimediaServiceImpl implements MultimediaService{
	
	@Autowired
	private MultimediaRepository multimediaRepository;

	@Override
	public Multimedia save(Multimedia multimedia) {
		multimedia.setDateCreation(new Date());
		return multimediaRepository.save(multimedia);
	}

	@Override
	public void delete(String _id) {
		multimediaRepository.deleteById(_id);
	}

	@Override
	public Multimedia getOne(String _id) {
		return multimediaRepository.findBy_id(_id);
	}

	@Override
	public List<Multimedia> getAll() {
		return multimediaRepository.findAll();
	}

	@Override
	public List<Multimedia> getAllIduserToAndType(String _iduserTo, String type) {
		return multimediaRepository.findAllBy_iduserToAndType(_iduserTo, type);
	}

	@Override
	public List<Multimedia> getAllIduserToAndTypeAndCategory(String _iduserTo, String type, String category) {
		return multimediaRepository.findAllBy_iduserToAndTypeAndCategory(_iduserTo, type, category);
	}
}
