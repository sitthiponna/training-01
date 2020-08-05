package com.train.service;

import com.train.model.StudentModel;
import com.train.model.request.CreateStudentRequest;
import com.train.model.request.UpdateStudentRequest;

import java.util.List;

public interface StudentService {

    List<StudentModel> getStudentList();
    StudentModel createStudent(CreateStudentRequest request);
    StudentModel updateStudent(UpdateStudentRequest request);
}
