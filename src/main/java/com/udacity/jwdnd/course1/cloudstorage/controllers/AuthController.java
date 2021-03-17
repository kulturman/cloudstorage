package com.udacity.jwdnd.course1.cloudstorage.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
public class AuthController {
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login(@RequestParam(name = "error", required = false) String error, Model model, HttpServletRequest request) {
		String referer = request.getHeader("referer");
		//This is a deconnection
		if(referer != null && referer.contains("home")) {
			model.addAttribute("logoutSuccess", true);
		}
		model.addAttribute("loginError", error);
		return "login";
	}
	
	@GetMapping("/signup")
	public String register() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String handleSignup(User user, Model model) {
		if(!userService.isUsernameFree(user.getUsername())) {
			model.addAttribute("errorMessage", "This username is not available");
		}
		else {
			model.addAttribute("success", true);
			userService.create(user);
		}
		return "signup";
	}
}
