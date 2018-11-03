package com.example.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.exception.ConflictException;
import com.exmple.model.User;

@Repository
public class UserRepo implements IUserRepo {
	private List<User> userList = new ArrayList<>();
	private int count = 0;

	@Override
	public User saveUser(User user) throws ConflictException {
		
		// isDuplicateUserExists(user)
		if (isDuplicateUserExists(user)) {
			throw new ConflictException("Duplicate Entry For User");
		}
		user.setId(generateId());
		userList.add(user);
		return user;
	}

	private int generateId() {
		count++;
		return count;
	}

	@Override
	public List<User> findAllUsers() {
		return userList;
	}

	public boolean isDuplicateUserExists(User user) {
		boolean duplicateUser=false;
		if(userList.indexOf(user)!=-1) {
			duplicateUser=true;
		}
			
//		for (User userObject : userList) {
//			if (userObject.getFirstName().equalsIgnoreCase(user.getFirstName())  && userObject.getLastName().equalsIgnoreCase(user.getLastName())) {
//				System.out.println("This User With Firstname: " + user.getFirstName() + "And With Lastname: "
//						+ user.getLastName() + "Already Exists");
//				duplicateUser = true;
//				break;
//			}
//		}
		return duplicateUser;
	}
}