package com.projects.springserviciosmeetpeople.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.springserviciosmeetpeople.document.ProfileComment;

@Repository
public interface ProfileCommentRepository extends MongoRepository<ProfileComment, Serializable>{
	ProfileComment findBy_id(String _id);
	List<ProfileComment> findAllBy_iduserTo(String _iduserTo);
}
