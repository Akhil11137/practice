package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ConflictException;
import com.example.exception.UserValidationException;
import com.example.service.UserService;
import com.example.utils.UserValidation;
import com.exmple.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<? extends Object> save(@RequestBody User user){
		
		ResponseEntity<? extends Object> response = null;
		try {
			UserValidation.userValidation(user);
			user=userService.save(user);
			response = new ResponseEntity<User>(user,HttpStatus.CREATED);
		} catch (UserValidationException e) {
			response = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		catch(ConflictException conflict) {
			response = new ResponseEntity<String>(conflict.getMessage(),HttpStatus.CONFLICT);
		}
		
		
		return response;
		
	}
	
	@RequestMapping(value="/userlist", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<? extends Object> userList(){
		List<User> list=userService.getAllUsers();
		return new ResponseEntity<List<User>> (list,HttpStatus.OK);
	}

}
