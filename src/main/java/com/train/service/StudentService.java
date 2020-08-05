package com.train.service;

import com.train.model.StudentModel;
import com.train.model.request.CreateStudentRequest;
import com.train.model.request.UpdateStudentRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentModel> getStudentList();
    StudentModel createStudent(CreateStudentRequest request);
    StudentModel updateStudent(UpdateStudentRequest request);
    Page<StudentModel> getStudentPagingList(Map<String, String> params);
}
