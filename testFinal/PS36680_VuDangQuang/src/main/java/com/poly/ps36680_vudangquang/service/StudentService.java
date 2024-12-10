package com.poly.ps36680_vudangquang.service;


import com.poly.ps36680_vudangquang.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String maSV);
    Student addStudent(Student student);
    int deleteStudent(String maSV);
}
