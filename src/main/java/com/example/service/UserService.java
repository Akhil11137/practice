package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.ConflictException;
import com.example.repository.IUserRepo;
import com.example.repository.UserRepo;
import com.exmple.model.User;

@Service
public class UserService implements IUserService {

	private IUserRepo userRepo;
	
	 public UserService(IUserRepo userRepo) {
		 this.userRepo=userRepo;
	 }

	@Override
	public User save(User user) throws ConflictException {
		userRepo.saveUser(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAllUsers();
	}
	
}
