package com.projects.springserviciosmeetpeople.service;

import java.util.List;


import com.projects.springserviciosmeetpeople.document.User;
import com.projects.springserviciosmeetpeople.exception.NameUserNotRepeated;
import com.projects.springserviciosmeetpeople.exception.UserNotFound;

public interface UserService {
	User save(User user) throws NameUserNotRepeated;
	User update(User user);
	void delete(String _id) throws UserNotFound;
	User getOne(String _id) throws UserNotFound;
	User getOneNameUser(String nameUser) throws UserNotFound;
	List<User> getAll();
	List<User> getAllLikeName(String name);
}
