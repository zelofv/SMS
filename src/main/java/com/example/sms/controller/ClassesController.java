package com.example.sms.controller;

import com.example.sms.dto.PageDto;
import com.example.sms.dto.Result;
import com.example.sms.entity.Teacher;
import com.example.sms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @projectName: SMS
 * @author: zelofv
 * @date: 2023/6/4 16:07
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getAllTeacher")
    public Result<Map<String, Object>> getAllTeacher(PageDto pageDto) {
        return teacherService.getAllTeacher(pageDto);
    }

    @PostMapping("/delTeacher")
    public Result<?> delTeacher(@RequestBody String sid) {
        return teacherService.deleteTeacher(sid);
    }

    @PostMapping("/addTeacher")
    public Result<?> addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("/updateTeacher")
    public Result<?> updateTeacher(@RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }

    @PostMapping("/delTeachers")
    public Result<?> delTeachers(@RequestBody List<String> delList) {
        return teacherService.delTeachers(delList);
    }

    @PostMapping("/selectTeacherByKV")
    public Result<Map<String, Object>> selectTeacherByKV(@RequestBody Map<String, Object> paramsMap) {
        return teacherService.selectTeacherByKV(paramsMap);
    }

}
