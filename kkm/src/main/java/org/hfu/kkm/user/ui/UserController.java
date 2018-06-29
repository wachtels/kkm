package org.hfu.kkm.user.ui;


import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.hfu.kkm.user.db.User;
import org.hfu.kkm.user.db.UserService;

@Model
public class UserController {

	@Inject
	UserService userService;
	
	private String name;

	private byte[] picture;
	
	public List<User> getAllUsers(){
		return userService.getAll();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
