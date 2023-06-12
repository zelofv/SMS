package com.example.sms.service.impl;

import com.example.sms.dao.StudentDao;
import com.example.sms.dto.PageDto;
import com.example.sms.dto.Result;
import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: SMS
 * @author: zelofv
 * @date: 2023/6/4 16:08
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Result<Map<String, Object>> getAllStudent(PageDto pageDto) {
        Result<Map<String, Object>> result = new Result<>();

        Map<String, Integer> limit = new HashMap<>();
        int page = pageDto.getPage();
        int pageSize = pageDto.getLimit();
        limit.put("from", (page - 1) * pageSize);
        limit.put("size", pageSize);
        List<Student> students = studentDao.getAllStudent(limit);

        HashMap<String, Object> map = new HashMap<>();
        map.put("student", students);
        map.put("count", getStudentCount(null));
        result.setStatus(Result.SUCCESS);
        result.setData(map);

        return result;
    }

    @Override
    public int getStudentCount(Map<String, Object> params) {
//        Map<String, Object> map = params == null ? new HashMap<>() : params;
        return params == null ? studentDao.getStudentCount() : studentDao.getStudentCountBy(params);
    }

    @Override
    public Student getStudentBySid(String sid) {
        return studentDao.getStudentBySid(sid);
    }

    @Override
    public Result<?> updateStudent(Student student) {
        Result<?> result = new Result<>();
        Student student1 = studentDao.getStudentBySid(student.getSid());
        if (student1 == null) {
            result.setStatus(Result.ERROR);
            result.setMessage("系统中不存在该学生");
            return result;
        } else if (student.toString().equals(student1.toString())) {
            result.setStatus(201);
            result.setMessage("修改前与修改后内容一致");
            return result;
        }
        int i = studentDao.updateStudent(student);
        if (i == 0) {
            result.setStatus(Result.ERROR);
            result.setMessage("修改学生信息失败");
        }
        result.setStatus(Result.SUCCESS);
        result.setMessage("修改成功~");
        return result;
    }

    @Override
    public Result<?> deleteStudent(String sid) {
        Result<?> result = new Result<>();
        Student student = studentDao.getStudentBySid(sid);
        if (student == null) {
            result.setStatus(Result.ERROR);
            result.setMessage("系统中不存在该学生");
            return result;
        }
        int i = studentDao.deleteStudent(sid);
        if (i == 0) {
            result.setStatus(Result.ERROR);
            result.setMessage("删除学生失败");
        }
        result.setStatus(Result.SUCCESS);
        result.setMessage("删除成功");
        return result;
    }

    @Override
    public Result<?> delStudents(List<String> delList) {
        Result<?> result = new Result<>();
        result.setStatus(Result.SUCCESS);
        StringBuilder message = new StringBuilder();
        for (String sid : delList) {
            Result<?> result1 = deleteStudent(sid);
            if (!(result1.getStatus() == Result.SUCCESS)) {
                message.append(sid).append("-").append(result1.getMessage()).append("\n");
                result.setStatus(result1.getStatus());
            }
        }
        message = new StringBuilder(message.toString().equals("") ? "删除成功" : message.toString());
        result.setMessage(message.toString());
        return result;
    }

    @Override
    public Result<Map<String, Object>> selectStudentByKV(Map<String, Object> params) {
        Result<Map<String, Object>> result = new Result<>();

        Map<String, Object> pageDto = (Map<String, Object>) params.remove("limit");
        params.put(String.valueOf(params.get("key")), params.get("value"));
        int page = (int) pageDto.get("page");
        int pageSize = (int) pageDto.get("limit");
        params.put("from", (page - 1) * pageSize);
        params.put("size", pageSize);
        List<Student> students = studentDao.selectStudentByKV(params);

        HashMap<String, Object> map = new HashMap<>();
        map.put("student", students);
        map.put("count", getStudentCount(params));
        result.setStatus(Result.SUCCESS);
        result.setData(map);

        return result;
    }

    @Override
    public Result<?> addStudent(Student student) {
        Result<?> result = new Result<>();
        Student student1 = studentDao.getStudentBySid(student.getSid());
        if (student1 != null) {
            result.setStatus(Result.ERROR);
            result.setMessage("系统中存在该学生" + student1.getSid() + "-" + student1.getName());
            return result;
        }
        int i = studentDao.addStudent(student);
        if (i == 0) {
            result.setStatus(Result.ERROR);
            result.setMessage("新增学生失败");
        }
        result.setStatus(Result.SUCCESS);
        result.setMessage("新增成功~");
        return result;
    }
}
