package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entities.Credential;
import com.udacity.jwdnd.course1.cloudstorage.mappers.CredentialMapper;

@Service
public class CredentialService {
	@Autowired
	private CredentialMapper credentialMapper;
	@Autowired
	EncryptionService encryptionService;
	
	public List<Credential> findByUserId(int userId) {
		return credentialMapper.findByUserId(userId);
	}
	
	public int create(Credential credential, int userId) {
		String key = encryptionService.generateRandomKey();
		credential.setKey(key);
		credential.setPassword(encryptionService.encryptValue(credential.getPassword(), key));
		credential.setUserId(userId);
		return credentialMapper.create(credential);
	}
	
	public int update(Credential credential) {
		String key = encryptionService.generateRandomKey();
		credential.setKey(key);
		credential.setPassword(encryptionService.encryptValue(credential.getPassword(), key));
		return credentialMapper.update(credential);
	}
	
	public int delete(int id) {
		return credentialMapper.delete(id);
	}
}
