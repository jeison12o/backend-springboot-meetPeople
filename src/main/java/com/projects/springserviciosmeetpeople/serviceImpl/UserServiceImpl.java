package com.projects.springserviciosmeetpeople.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.springserviciosmeetpeople.document.User;
import com.projects.springserviciosmeetpeople.exception.NameUserNotRepeated;
import com.projects.springserviciosmeetpeople.exception.UserNotFound;
import com.projects.springserviciosmeetpeople.repository.UserRepository;
import com.projects.springserviciosmeetpeople.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired(required = true)
	private UserRepository userRepository;
	
	@Override
	public User save(User user) throws NameUserNotRepeated {
		User p = userRepository.findByNameUser(user.getNameUser());
		if (p == null) {
			return userRepository.insert(user);
		} else {
			throw new NameUserNotRepeated();
		}
		
	}
	
	@Override
	public User update(User user) {
		return userRepository.save(user);
	}
	
	
	@Override
	public void delete(String _id) throws UserNotFound {
		User user = userRepository.findBy_id(_id);
		if(user == null) throw new UserNotFound();
		userRepository.deleteById(_id);
	}

	@Override
	public User getOne(String _id) throws UserNotFound {
		User user = userRepository.findBy_id(_id);
		if(user == null) throw new UserNotFound();
		return user;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getOneNameUser(String nameUser) throws UserNotFound {
		User user = userRepository.findByNameUser(nameUser);
		if(user == null) throw new UserNotFound();
		return user;
	}

	@Override
	public List<User> getAllLikeName(String name) {
		return userRepository.findAllByNameUserOrNameLike(name, name);
	}
	
}
