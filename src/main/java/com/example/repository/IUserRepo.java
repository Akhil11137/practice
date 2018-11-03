package com.example.repository;

import java.util.List;

import com.example.exception.ConflictException;
import com.exmple.model.User;

public interface IUserRepo {
	
	public User saveUser(User user) throws ConflictException;
	
	public List<User> findAllUsers();
}
