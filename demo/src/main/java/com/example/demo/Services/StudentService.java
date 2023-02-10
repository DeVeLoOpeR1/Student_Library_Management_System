package com.example.demo.Services;

import com.example.demo.Models.Card;
import com.example.demo.Enums.CardStatus;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    //making a bean of StudentRepository
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student){


        //first set all the data of the field before saving IT THE DATABASE
        //first set child class data
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        //let set the student entity data
        student.setCard(card);

        //due to casecading effect the child entitiy also to database with the parent entity to maintain
        // consistency
        studentRepository.save(student);


        return "Student added successfully";
    }
}
