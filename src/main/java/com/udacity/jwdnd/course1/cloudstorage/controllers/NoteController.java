package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udacity.jwdnd.course1.cloudstorage.entities.Note;
import com.udacity.jwdnd.course1.cloudstorage.entities.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;

@Controller
public class NoteController {
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/notes")
	public String save(Note note, Authentication authentication) {
		User user = (User)authentication.getPrincipal();
		if(note.getNoteId() == null) {
			noteService.create(note, user.getUserid());
		}
		else {
			noteService.update(note);
		}
		return "redirect:/home#notes";
	}
	
	@PostMapping("/notes/delete")
	public String delete(@RequestParam(name = "noteId") int noteId) {
		noteService.delete(noteId);
		return "redirect:/home#notes";
	}
}
