package com.train.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest {

    private String studentId;
    private String firstName;
    private String lastName;
    private String age;
    private String grade;
}
