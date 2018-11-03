package com.example.service;

import java.util.List;

import com.example.exception.ConflictException;
import com.exmple.model.User;

public interface IUserService {

	public User save(User user) throws ConflictException;

	public List<User> getAllUsers();
}
