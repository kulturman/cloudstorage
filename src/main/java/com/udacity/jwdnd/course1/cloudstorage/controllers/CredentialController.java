package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udacity.jwdnd.course1.cloudstorage.entities.Credential;
import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;

@Controller
public class CredentialController {
	@Autowired
	CredentialService credentialService;
	
	@PostMapping("/credentials")
	public String save(Credential credential, Authentication authentication) {
		User user = (User)authentication.getPrincipal();
		if(credential.getCredentialId() == null) {
			credentialService.create(credential, user.getUserid());
		}
		else {
			credentialService.update(credential);
		}
		return "redirect:/home#credentials";
	}
	
	@PostMapping("/credentials/delete")
	public String delete(@RequestParam(name = "credentialId") int credentialId) {
		credentialService.delete(credentialId);
		return "redirect:/home#credentials";
	}
}
