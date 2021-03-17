package com.udacity.jwdnd.course1.cloudstorage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.entities.Note;
import com.udacity.jwdnd.course1.cloudstorage.mappers.NoteMapper;

@Service
public class NoteService {
	@Autowired
	private NoteMapper noteMapper;
	
	public int create(Note note, int userId) {
		note.setUserId(userId);
		return noteMapper.create(note);
	}
	
	public int update(Note note) {
		return noteMapper.update(note);
	}
	
	public List<Note> findByUserId(int userId) {
		return noteMapper.findByUserId(userId);
	}
	
	public int delete(int id) {
		return noteMapper.delete(id);
	}
}
