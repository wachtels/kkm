package bean;


import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.Lob;

import ejb.UserEJB;
import entity.User;

@ApplicationScoped
@ManagedBean
public class UserBean {

	@Inject
	UserEJB userEJB;
	
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
