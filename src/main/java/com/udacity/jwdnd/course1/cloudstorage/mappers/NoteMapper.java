package com.udacity.jwdnd.course1.cloudstorage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.entities.Note;

@Mapper
public interface NoteMapper {
	@Select("SELECT * FROM NOTES WHERE userId = #{userId}")
	List<Note> findByUserId(int id);
	
	@Insert("INSERT INTO NOTES(userId, noteDescription, noteTitle) VALUES(#{userId}, #{noteDescription}, #{noteTitle})")
	@Options(useGeneratedKeys = true, keyProperty = "noteId")
	int create(Note note);
	
	@Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
	int delete(int noteId);
	
	@Update("UPDATE NOTES SET noteDescription = #{noteDescription}, noteTitle = #{noteTitle} WHERE noteId = #{noteId}")
	int update(Note note);
}
