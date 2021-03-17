package com.udacity.jwdnd.course1.cloudstorage.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.udacity.jwdnd.course1.cloudstorage.entities.File;
import com.udacity.jwdnd.course1.cloudstorage.mappers.FileMapper;

@Service
public class FileService {
	@Autowired
	private FileMapper fileMapper;
	
	public List<File> findByUserId(int userId) {
		return fileMapper.findByUserId(userId);
	}
	
	public int create(int userId, MultipartFile fileUpload) throws IOException {
		File file = new File();
		file.setContentType(fileUpload.getContentType());
		file.setFileData(fileUpload.getBytes());
		file.setUserId(userId);
		file.setFileName(fileUpload.getOriginalFilename());
		return fileMapper.create(file);
	}
	
	public int delete(int fileId) {
		return fileMapper.delete(fileId);
	}
	
	public File find(int fileId) {
		return fileMapper.find(fileId);
	}
	
	public boolean doesFileExist(String fileName, int userId) {
		return fileMapper.doesFileExist(fileName, userId) > 0;
	}
}
