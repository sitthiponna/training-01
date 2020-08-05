package com.train.service.impl;

import com.train.model.StudentModel;
import com.train.model.enumerate.Grade;
import com.train.model.request.CreateStudentRequest;
import com.train.model.request.UpdateStudentRequest;
import com.train.repository.StudentRepository;
import com.train.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentModel> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel createStudent(CreateStudentRequest request) {
        StudentModel studentModel = StudentModel.builder()
                .studentId(UUID.randomUUID().toString())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(Integer.parseInt(request.getAge()))
                .grade(Grade.valueOf(request.getGrade()))
                .build();
        studentRepository.save(studentModel);

        return studentRepository.findById(studentModel.getStudentId()).orElse(null);
    }

    @Override
    public StudentModel updateStudent(UpdateStudentRequest request) {
        StudentModel studentModel = StudentModel.builder()
                .studentId(request.getStudentId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(Integer.parseInt(request.getAge()))
                .grade(Grade.valueOf(request.getGrade()))
                .build();
        studentRepository.save(studentModel);
        return studentRepository.findById(studentModel.getStudentId()).orElse(null);
    }
}
