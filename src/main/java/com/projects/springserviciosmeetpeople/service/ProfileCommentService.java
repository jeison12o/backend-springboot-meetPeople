package com.projects.springserviciosmeetpeople.service;

import java.util.List;

import com.projects.springserviciosmeetpeople.document.ProfileComment;

public interface ProfileCommentService {
	ProfileComment save(ProfileComment profileComment);
	void delete(String _id) throws Exception;
	ProfileComment getOne(String _id) throws Exception;
	List<ProfileComment> getAll();
	List<ProfileComment> getAllUserTo(String _iduserTo);
}
