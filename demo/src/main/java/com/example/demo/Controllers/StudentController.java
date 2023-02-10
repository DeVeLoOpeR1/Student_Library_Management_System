package com.example.demo.Controllers;

import com.example.demo.Models.Student;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping
    public class StudentController {

        // making and getting the bean StudentService class
        @Autowired
        StudentService studentService;

        @PostMapping("/add")
        public String addStudent (@RequestBody Student student){
            return studentService.addStudent(student);
        }
    }


