package com.udacity.jwdnd.course1.cloudstorage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.entities.Credential;

@Mapper
public interface CredentialMapper {
	@Select("SELECT * FROM CREDENTIALS WHERE userId = #{userId}")
	List<Credential> findByUserId(int userId);
	
	@Insert("INSERT INTO CREDENTIALS(url, username, userId, password, key) VALUES(#{url}, #{username}, #{userId}, #{password}, #{key})")
	@Options(useGeneratedKeys = true, keyProperty = "credentialId")
	int create(Credential credential);
	
	@Update("UPDATE CREDENTIALS SET url = #{url}, username = #{username}, password = #{password}, key = #{key}")
	int update(Credential credential);
	
	@Delete("DELETE FROM CREDENTIALS WHERE credentialId = #{id}")
	int delete(int id);
}
