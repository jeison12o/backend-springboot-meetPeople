package com.projects.springserviciosmeetpeople.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.projects.springserviciosmeetpeople.document.User;

@Repository
public interface UserRepository extends MongoRepository<User, Serializable>{
	User findByNameUser(String nameUser);
	List<User> findAllByNameUserOrNameLike(String nameUser, String name);
	User findBy_id(String _id);
}