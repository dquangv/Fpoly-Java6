package com.poly.ps36680_vudangquang.rest.controller;

import com.poly.ps36680_vudangquang.entity.Student;
import com.poly.ps36680_vudangquang.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRestController {
    private final StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        Map<String, Object> res = new LinkedHashMap<>();
        try {
            res.put("data", studentService.getAllStudents());
            res.put("success", true);
            res.put("message", HttpStatus.OK);
            res.put("status", HttpStatus.OK.value());
        }catch (Exception e) {
            res.put("data", null);
            res.put("success", false);
            res.put("message", e.getMessage());
            res.put("status", HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.ok(res);
    }
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        Map<String, Object> res = new LinkedHashMap<>();
        try {
            res.put("data", studentService.addStudent(student));
            res.put("success", true);
            res.put("message", HttpStatus.OK);
            res.put("status", HttpStatus.OK.value());
        }catch (Exception e) {
            res.put("data", null);
            res.put("success", false);
            res.put("message", e.getMessage());
            res.put("status", HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.ok(res);
    }
    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        Map<String, Object> res = new LinkedHashMap<>();
        try {
            res.put("data", studentService.addStudent(student));
            res.put("success", true);
            res.put("message", HttpStatus.OK);
            res.put("status", HttpStatus.OK.value());
        }catch (Exception e) {
            res.put("data", null);
            res.put("success", false);
            res.put("message", e.getMessage());
            res.put("status", HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.ok(res);
    }
    @DeleteMapping("/{maSV}")
    public ResponseEntity<?> deleteStudent(@PathVariable String maSV) {
        Map<String, Object> res = new LinkedHashMap<>();
        try {
            res.put("data", studentService.deleteStudent(maSV));
            res.put("success", true);
            res.put("message", HttpStatus.OK);
            res.put("status", HttpStatus.OK.value());
        }catch (Exception e) {
            res.put("data", null);
            res.put("success", false);
            res.put("message", e.getMessage());
            res.put("status", HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.ok(res);
    }
    @GetMapping("/{maSV}")
    public ResponseEntity<?> getStudentById(@PathVariable String maSV) {
        Map<String, Object> res = new LinkedHashMap<>();
        try {
            res.put("data", studentService.getStudentById(maSV));
            res.put("success", true);
            res.put("message", HttpStatus.OK);
            res.put("status", HttpStatus.OK.value());
        }catch (Exception e) {
            res.put("data", null);
            res.put("success", false);
            res.put("message", e.getMessage());
            res.put("status", HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.ok(res);
    }
}
