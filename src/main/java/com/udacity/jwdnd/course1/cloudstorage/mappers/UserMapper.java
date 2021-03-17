package com.udacity.jwdnd.course1.cloudstorage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.udacity.jwdnd.course1.cloudstorage.entities.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USERS WHERE username = #{username}")
	User findByUsername(String username);
	
	@Insert("INSERT INTO USERS(salt, password, username, firstname, lastname) VALUES(#{salt}, #{password}, #{username}, #{firstname}, #{lastname})")
	@Options(useGeneratedKeys = true, keyProperty = "userid")
	int create(User user);
	
	@Select("SELECT * FROM USERS")
	List<User> getAll();

}
