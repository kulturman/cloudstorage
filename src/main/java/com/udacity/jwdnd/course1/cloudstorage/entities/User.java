package com.udacity.jwdnd.course1.cloudstorage.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User {
	private int userid;
	private String password;
	private String username;
	private String salt;
	private String lastname;
	private String firstname;
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", username=" + username + ", salt=" + salt
				+ ", lastname=" + lastname + ", firstname=" + firstname + "]";
	}

}
