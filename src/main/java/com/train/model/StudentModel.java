package com.train.model;

import com.train.model.enumerate.Grade;
import com.train.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = StudentRepository.tableName)
public class StudentModel {

    @Id
    @Column(nullable = false)
    private String studentId;
    private String firstName;
    private String lastName;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Grade grade;
}
