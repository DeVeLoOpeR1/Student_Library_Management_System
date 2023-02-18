package com.example.demo.Services;

import com.example.demo.Models.Book;
import com.example.demo.RequestDto.StudentDto;
import com.example.demo.RequestDto.StudentIdDto;
import com.example.demo.RequestDto.UpdateMobNoStudentDto;
import com.example.demo.RequestDto.UpdateNameStudentDto;
import com.example.demo.Models.Card;
import com.example.demo.Enums.CardStatus;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import com.example.demo.ResponseDto.BookAssignedResponseDto;
import com.example.demo.ResponseDto.BookResponseDto;
import com.example.demo.ResponseDto.StudentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    //making a bean of StudentRepository
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentDto studentDto) {

        //convert the StudentDto object to the normal student object
        //now studentDto only contain some data which is we have take it input from the user but some data
        //already auto created there

        Student student = new Student(); //create a new object of student entity
        student.setMobNo(studentDto.getMobNo());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        // first we need to set the attribute of the student object then only we have to save it

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent1(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student Added Successfully "+student.getId()+" Id ";
    }

    public BookAssignedResponseDto bookIssuedByStudentId(StudentIdDto studentIdDto) {
        try {
            Student student = studentRepository.findById(studentIdDto.getId()).get();
            // get the card object from the repository
            Card card = student.getCard();
            //create a obj BookAssignedResponseDto
            BookAssignedResponseDto bookAssignedResponseDto = new BookAssignedResponseDto();

            List<Book> bookList = card.getIssued(); //now we get the list of book associated with id

            //convert the List<Book> --> List<BookResponseDto>
            List<BookResponseDto> bookResponseDtoList = new ArrayList<>();
            for(Book book : bookList){
                //create a new BookResponseDto for each book
                BookResponseDto bookResponseDto = new BookResponseDto();
                bookResponseDto.setAuthorId(book.getAuthor().getId());
                bookResponseDto.setWriter(book.getWriter());
                bookResponseDto.setGenre(book.getGenre());
                bookResponseDto.setName(book.getName());
                bookResponseDto.setId(book.getId());
                // now bookResponse obj is created successfully then store it into the list
                bookResponseDtoList.add(bookResponseDto);
            }

            // now we have set the list of the book
            // set the other attribute of the BookAssignedResponseDto
            bookAssignedResponseDto.setId(student.getId()); //where need to set student id
            bookAssignedResponseDto.setName(student.getName()); // where we need to set the student name
            bookAssignedResponseDto.setBookResponseDtoList(bookResponseDtoList); //book list is set to go

            return bookAssignedResponseDto;


        }
        catch(Exception e) {

            e.getMessage();
        }
        return new BookAssignedResponseDto();
    }

    public StudentResponseDto getStudent(StudentIdDto studentIdDto) {

        int studentId = studentIdDto.getId();
        Student student;
        try {
             student = studentRepository.findById(studentId).get(); // now we get the student object
            // convert the student --> studentResponseDto
            StudentResponseDto studentResponseDto = new StudentResponseDto(); //make new response object
            studentResponseDto.setId(student.getId());
            studentResponseDto.setEmail(student.getEmail());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setMobNo(student.getMobNo());

            return studentResponseDto;
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return new StudentResponseDto();
    }

    public String updateStudentName(UpdateNameStudentDto updateNameStudentDto) {
        //now we need to perform the converter operation of the Dto object to the Entity object

        try{

            Student student = studentRepository.findById(updateNameStudentDto.getId()).get(); //get the object of the student

            //update the name of the student and then save it back to the database
            student.setName(updateNameStudentDto.getName());
            studentRepository.save(student);

            return "Name Updated Successfully";
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return "Invalid Student Data please check and update";

    }
    public String updateMobNoStudent(UpdateMobNoStudentDto updateMobNoStudentDto) {

        try{
            Student student = studentRepository.findById(updateMobNoStudentDto.getId()).get();
            student.setMobNo(updateMobNoStudentDto.getMobNo());
            studentRepository.save(student);
            return "Mobile Number of the Student is updated SuccessFully";
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return "Invalid Student data please check and update it later";
    }

}
