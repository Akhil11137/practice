package com.example.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.exception.UserValidationException;
import com.exmple.model.User;

public class UserValidation {
	
	public static void userValidation(User user) throws UserValidationException {
		if(null==user.getFirstName() ||  "".equals(user.getFirstName().trim())) {
			throw new UserValidationException("Firstname Is Invalid");
		}
		if(null==user.getLastName() || "".equals(user.getLastName().trim())) {
			throw new UserValidationException("Lastname Is Invalid");
		}
		
	}
	
}
