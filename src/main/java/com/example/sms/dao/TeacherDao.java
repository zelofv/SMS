package com.example.sms.dao;

import com.example.sms.dto.Result;
import com.example.sms.entity.Student;
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
public interface StudentDao {

    List<Student> getAllStudent(Map<String, Integer> limit);

    List<Student> selectStudentByKV(Map<String, Object> params);

    int getStudentCount();

    int getStudentCountBy(Map<String, Object> params);

    Student getStudentBySid(String sid);

    int updateStudent(Student student);

    int deleteStudent(String sid);

    int addStudent(Student student);

}
