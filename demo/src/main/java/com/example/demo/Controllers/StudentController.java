package com.example.demo.Controllers;

import com.example.demo.RequestDto.StudentDto;
import com.example.demo.RequestDto.StudentIdDto;
import com.example.demo.RequestDto.UpdateMobNoStudentDto;
import com.example.demo.RequestDto.UpdateNameStudentDto;
import com.example.demo.ResponseDto.BookAssignedResponseDto;
import com.example.demo.ResponseDto.StudentResponseDto;
import com.example.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping("student")
    public class StudentController {

        // making and getting the bean StudentService class
        @Autowired
        StudentService studentService;

    @PostMapping("/add")
    public String addStudent (@RequestBody StudentDto studentDto){

        return studentService.addStudent(studentDto);
    }
    @GetMapping("book_assigned")
    public BookAssignedResponseDto bookIssuedByStudentId(@RequestBody StudentIdDto studentIdDto){
        return studentService.bookIssuedByStudentId(studentIdDto);
    }

    @GetMapping("get_student")
    public StudentResponseDto getStudent(@RequestBody StudentIdDto studentIdDto){
        return studentService.getStudent(studentIdDto);
    }

    @PutMapping("updateStudentName")
    public String updateStudentName(@RequestBody UpdateNameStudentDto updateNameStudentDto){
        return studentService.updateStudentName(updateNameStudentDto);
    }
    @PutMapping("updateStudentMobileNumber")
    public String updateMobNoStudent(@RequestBody UpdateMobNoStudentDto updateMobNoStudentDto)
    {
        return studentService.updateMobNoStudent(updateMobNoStudentDto);
    }

    }


