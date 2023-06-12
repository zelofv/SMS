package com.example.sms.controller;

import com.example.sms.dto.PageDto;
import com.example.sms.dto.Result;
import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Style;
import java.util.List;
import java.util.Map;

/**
 * @projectName: SMS
 * @author: zelofv
 * @date: 2023/6/4 16:07
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudent")
    public Result<Map<String, Object>> getAllStudent(PageDto pageDto) {
        return studentService.getAllStudent(pageDto);
    }

    @PostMapping("/delStudent")
    public Result<?> delStudent(@RequestBody String sid) {
        return studentService.deleteStudent(sid);
    }

    @PostMapping("/addStudent")
    public Result<?> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/updateStudent")
    public Result<?> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @PostMapping("/delStudents")
    public Result<?> delStudents(@RequestBody List<String> delList) {
        return studentService.delStudents(delList);
    }

    @PostMapping("/selectStudentByKV")
    public Result<Map<String, Object>> selectStudentByKV(@RequestBody Map<String, Object> paramsMap) {
        return studentService.selectStudentByKV(paramsMap);
    }

}
