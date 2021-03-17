package com.udacity.jwdnd.course1.cloudstorage.entities;

import java.util.Arrays;

public class File {
	private int fileId;
	private String fileName;
	private String contentType;
	private String fileSize;
	private int userId;
	private byte[] fileData;
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", fileName=" + fileName + ", contentType=" + contentType + ", fileSize="
				+ fileSize + ", userId=" + userId + ", fileData=" + Arrays.toString(fileData) + "]";
	}
	
}
