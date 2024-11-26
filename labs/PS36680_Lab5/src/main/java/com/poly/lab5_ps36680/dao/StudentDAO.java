package com.poly.lab5_ps36680.dao;

import com.poly.lab5_ps36680.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentDAO extends JpaRepository<Student, String>{

}
