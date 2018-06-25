package org.hfu.kkm.user.ui;


import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.Lob;

import org.hfu.kkm.user.db.User;
import org.hfu.kkm.user.db.UserService;

@ApplicationScoped
@ManagedBean
public class UserController {

	@Inject
	UserService userEJB;
	
	private String name;

	private byte[] picture;
	
	public List<User> getAllUsers(){
		return userEJB.getAll();
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
