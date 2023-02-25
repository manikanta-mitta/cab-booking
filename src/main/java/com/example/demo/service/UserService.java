package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.User;
import com.example.demo.exceptions.UserAlreadyExistsException;

public class UserService {
	private Map<String, User> users = new HashMap<>();

	public void addUser(User user) throws UserAlreadyExistsException {
		
		if (doesUserExist(user.getName())) {
			throw new UserAlreadyExistsException();
		}
		users.put(user.getName(), user);
	}
	
	public boolean doesUserExist(String name) {
		return users.containsKey(name);
	}
	
}
