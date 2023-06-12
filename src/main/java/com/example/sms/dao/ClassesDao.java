package com.example.sms.dao;

import com.example.sms.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @projectName: SMS
 * @author: zelofv
 * @date: 2023/6/4 16:19
 */
@Mapper
@Repository
public interface TeacherDao {

    List<Teacher> getAllTeacher(Map<String, Integer> limit);

    Map<String, Object> selectTeacherByKV(Map<String, Object> params);

    int getTeacherCount();

    int getTeacherCountBy(Map<String, Object> params);

    Teacher getTeacherByTid(String tid);

    int updateTeacher(Teacher student);

    int deleteTeacher(String tid);

    int addTeacher(Teacher student);

}
