package com.train.controller;

import com.train.model.StudentModel;
import com.train.model.request.CreateStudentRequest;
import com.train.model.request.UpdateStudentRequest;
import com.train.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/student/list")
    public List<StudentModel> getStudentList() {
        return studentService.getStudentList();
    }

    @PostMapping(path = "/student")
    public StudentModel createStudent(@RequestBody CreateStudentRequest request) {
        return studentService.createStudent(request);
    }

    @PutMapping(path = "/student")
    public StudentModel updateStudent(@RequestBody UpdateStudentRequest request) {
        return studentService.updateStudent(request);
    }
}
