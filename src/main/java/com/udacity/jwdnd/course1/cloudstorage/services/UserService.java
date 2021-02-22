package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.mappers.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	HashService hashService;
	
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userMapper.findByUsername(username);
	}
	
	public int create(User user) {
		byte[] salt = new byte[16];
		new Random().nextBytes(salt);
		String encodedSalt = Base64.getEncoder().encodeToString(salt);
		user.setPassword(hashService.getHashedValue(user.getPassword(), encodedSalt));
		return userMapper.create(user);
	}
	
	public List<User> getAll() {
		return userMapper.getAll();
	}

}
