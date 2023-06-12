package com.example.sms.service;

import com.example.sms.dto.PageDto;
import com.example.sms.dto.Result;
import com.example.sms.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @projectName: SMS
 * @author: zelofv
 * @date: 2023/6/4 16:08
 */
public interface StudentService {
    Result<Map<String, Object>> getAllStudent(PageDto pageDto);

    int getStudentCount(Map<String, Object> params);

    Student getStudentBySid(String sid);

    Result<?> updateStudent(Student student);

    Result<?> deleteStudent(String sid);

    Result<?> delStudents(List<String> delList);

    Result<Map<String, Object>> selectStudentByKV(Map<String, Object> params);

    Result<?> addStudent(Student student);
}
