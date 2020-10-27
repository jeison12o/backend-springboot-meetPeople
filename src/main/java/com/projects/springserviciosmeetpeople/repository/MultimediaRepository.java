package com.projects.springserviciosmeetpeople.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.springserviciosmeetpeople.document.Multimedia;

@Repository
public interface MultimediaRepository extends MongoRepository<Multimedia, Serializable>{
	Multimedia findBy_id(String _id);
	List<Multimedia> findAllBy_iduserToAndType(String _iduserTo, String type);
	List<Multimedia> findAllBy_iduserToAndTypeAndCategory(String _iduserTo, String type, String category);
}