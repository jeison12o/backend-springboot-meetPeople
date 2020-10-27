package com.projects.springserviciosmeetpeople.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.springserviciosmeetpeople.document.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Serializable>{
}
