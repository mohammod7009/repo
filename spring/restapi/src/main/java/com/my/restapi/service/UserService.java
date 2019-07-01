package com.my.restapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.my.restapi.model.User;

public class UserService {

	// static collection of users - not using database here
	private static List<User> users = new ArrayList<User>();

	public List<User> getAllUsers() {
		return users;
	}

	public void save(@Valid User u) {
		users.add(u);
	}

	public User findUser(int id) {
		for (User u: users) {
			if (u.getId() == id) {
				return u;
			}
		}		
		return null;
	}

	public void remove(User u) {
		users.remove(u);
	}
	

}
