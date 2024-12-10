package com.poly.ps36680_vudangquang.repository;


import com.poly.ps36680_vudangquang.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
