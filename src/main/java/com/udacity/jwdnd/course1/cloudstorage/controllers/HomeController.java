package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;

@Controller
public class HomeController {
	@Autowired
	private NoteService noteService;
	@Autowired
	private CredentialService credentialService;
	@Autowired
	private FileService fileService;
	@Autowired
	private EncryptionService encryptionService;
	
	@GetMapping("home")
	public String home(Model model, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
		User user = (User) usernamePasswordAuthenticationToken.getPrincipal();
		int userId = user.getUserid();
		model.addAttribute("notes", noteService.findByUserId(userId));
		model.addAttribute("credentials", credentialService.findByUserId(userId));
		model.addAttribute("files", fileService.findByUserId(userId));
		model.addAttribute("encryptionService", encryptionService);
		return "home";
	}
}
