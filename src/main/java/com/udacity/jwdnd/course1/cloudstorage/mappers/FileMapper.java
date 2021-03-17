package com.udacity.jwdnd.course1.cloudstorage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.course1.cloudstorage.entities.File;

@Mapper
public interface FileMapper {
    @Select("SELECT * FROM FILES WHERE userid = #{userid}")
    List<File> findByUserId(int userid);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, filedata, userid) VALUES (#{fileName}, #{contentType}, #{fileSize}, #{fileData}, #{userId})")
    int create(File file);

    @Delete("DELETE FROM FILES WHERE fileid = #{fileId}")
    int delete(int fileId);
    
    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    File find(int fileId);
    
    @Select("SELECT COUNT(*) FROM FILES WHERE filename = #{fileName} AND userId = #{userId}")
    int doesFileExist (String fileName, int userId);
}
