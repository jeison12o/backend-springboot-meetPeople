package com.projects.springserviciosmeetpeople.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.springserviciosmeetpeople.document.ProfileComment;
import com.projects.springserviciosmeetpeople.repository.ProfileCommentRepository;
import com.projects.springserviciosmeetpeople.service.ProfileCommentService;

@Service
public class ProfileCommentServiceImpl implements ProfileCommentService{
	
	@Autowired
	private ProfileCommentRepository profileCommentRepository; 

	@Override
	public ProfileComment save(ProfileComment profileComment) {
		return profileCommentRepository.save(profileComment);
	}

	@Override
	public void delete(String _id) throws Exception {
		profileCommentRepository.deleteById(_id);
	}

	@Override
	public ProfileComment getOne(String _id) throws Exception {
		return profileCommentRepository.findBy_id(_id);
	}

	@Override
	public List<ProfileComment> getAll() {
		return profileCommentRepository.findAll();
	}

	@Override
	public List<ProfileComment> getAllUserTo(String _iduserTo) {
		return profileCommentRepository.findAllBy_iduserTo(_iduserTo);
	}
}
