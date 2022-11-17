package com.example.demo.controllers;

import com.example.demo.dtos.StudentDto;
import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping(path = "/api/students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final ModelMapper mapper;

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody StudentDto studentDto) {
        Student student = mapper.map(studentDto, Student.class);
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
