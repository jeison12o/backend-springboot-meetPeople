package com.projects.springserviciosmeetpeople.serviceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloudinary.utils.ObjectUtils;
import com.projects.springserviciosmeetpeople.conf.CloudinaryConfig;
import com.projects.springserviciosmeetpeople.document.Multimedia;
import com.projects.springserviciosmeetpeople.dto.MultimediaRequest;
import com.projects.springserviciosmeetpeople.repository.MultimediaRepository;
import com.projects.springserviciosmeetpeople.service.MultimediaService;

@Repository
public class MultimediaServiceImpl implements MultimediaService{
	
	@Autowired
	private MultimediaRepository multimediaRepository;
	
	@Autowired
    private CloudinaryConfig cloudc;

	@Override
	public Multimedia save(MultimediaRequest multimedia) {
		Multimedia m = new Multimedia();
		m.setDateCreation(new Date());
		m.set_iduserTo(multimedia.get_iduserTo());
		m.setCategory(multimedia.getCategory());
		m.setType(multimedia.getType());
		Map uploadResult = null;
		try {
			uploadResult = cloudc.upload(multimedia.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		m.setUrl(uploadResult.get("url").toString());
		return multimediaRepository.save(m);
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
