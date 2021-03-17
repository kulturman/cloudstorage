package com.udacity.jwdnd.course1.cloudstorage.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.udacity.jwdnd.course1.cloudstorage.entities.File;
import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	
	@PostMapping("/files")
	public String saveFile(@RequestParam MultipartFile fileUpload, Authentication authentication, RedirectAttributes redirectAttributes) {
		User user = (User) authentication.getPrincipal();
		if(fileService.doesFileExist(fileUpload.getOriginalFilename(), user.getUserid())) {
			redirectAttributes.addFlashAttribute("uploadError", "There is already a file with this name");
		}
		else {
			try {
				fileService.create(user.getUserid(), fileUpload);
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("uploadError", e.getMessage());
			}
		}
		return "redirect:/home";
	}
	
	@PostMapping("/files/delete")
	public String delete(@RequestParam(name = "fileId") int fileId) {
		fileService.delete(fileId);
		return "redirect:/home";
	}
	
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> download(@PathVariable int id) {
		File file = fileService.find(id);
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFileName() + "\"")
		        .body(file.getFileData());
	}
	
}
