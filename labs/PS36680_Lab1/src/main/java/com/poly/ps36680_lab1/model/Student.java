package com.poly.ps36680_lab1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentID;
    private String name;
    private Boolean gender = false;
    private Double marks = 0.0;
    private String email;
    private String major;
    private int yearOfStudy;

    @Override
    public String toString() {
        return String.format(
                ">> Student ID: %s\n" +
                ">> Name: %s\n" +
                ">> Gender: %s\n" +
                ">> Marks: %.1f\n" +
                ">> Email: %s\n" +
                ">> Major: %s\n" +
                ">> Year of Study: %d\n",
                studentID, name, gender ? "Male" : "Female", marks, email, major, yearOfStudy
        );
    }
}
