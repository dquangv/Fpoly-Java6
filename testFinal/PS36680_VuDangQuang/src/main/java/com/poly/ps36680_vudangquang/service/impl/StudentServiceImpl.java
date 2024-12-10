package com.poly.ps36680_vudangquang.service.impl;

import com.poly.ps36680_vudangquang.entity.Student;
import com.poly.ps36680_vudangquang.repository.StudentRepository;
import com.poly.ps36680_vudangquang.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String maSV) {
        return studentRepository.findById(maSV).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public int deleteStudent(String maSV) {
        studentRepository.deleteById(maSV);
        return 1;
    }
}
