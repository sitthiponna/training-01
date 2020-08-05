package com.train.service.impl;

import com.train.model.StudentModel;
import com.train.model.enumerate.Grade;
import com.train.model.request.CreateStudentRequest;
import com.train.model.request.UpdateStudentRequest;
import com.train.repository.StudentRepository;
import com.train.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
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

    @Override
    public Page<StudentModel> getStudentPagingList(Map<String, String> params) {
        String firstName = params.get("firstName");
        String lastName = params.get("lastName");
        String age = params.get("age");
        String grade = params.get("grade");
        String page = params.get("p");
        String pageSize = params.get("ps");
        String sort = params.get("s");
        String sortDirection = params.get("sd");

        StudentModel studentModel = StudentModel.builder()
                .studentId("1f1f4d2d-1452-48d4-9a85-e9a076f3d143")
                .firstName(firstName)
                .lastName(lastName)
                .age(StringUtils.isEmpty(age) ? null : Integer.parseInt(age))
                .grade(StringUtils.isEmpty(grade) ? null : Grade.valueOf(grade))
                .build();
        Pageable paging = PageRequest.of(
                Integer.parseInt(page)
                , Integer.parseInt(pageSize)
                , Sort.Direction.fromString(StringUtils.isEmpty(sortDirection) ? "DESC" : sortDirection)
                , StringUtils.isEmpty(sort) ? "firstName" : sort);
        Page<StudentModel> response = studentRepository.findAll(Example.of(studentModel), paging);
        return response;
    }
}
