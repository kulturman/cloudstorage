package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.mappers.UserMapper;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = userMapper.findByUsername(username);
		if(userDetails != null) {
			return userDetails;
		}
		throw new UsernameNotFoundException("Bad credentials");
	}
	
	public int create(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userMapper.create(user);
	}
	
	public List<User> getAll() {
		return userMapper.getAll();
	}
	
	public boolean isUsernameFree(String username) {
		return userMapper.findByUsername(username) == null;
	}

}
