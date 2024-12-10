package com.poly.ps36680_vudangquang.service;


import com.poly.ps36680_vudangquang.entity.Employee;

import java.util.List;

public interface StudentService {
    List<Employee> getAllStudents();
    Employee getStudentById(String maSV);
    Employee addStudent(Employee student);
    int deleteStudent(String maSV);
}
