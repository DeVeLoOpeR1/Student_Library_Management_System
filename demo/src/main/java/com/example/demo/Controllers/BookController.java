package com.example.demo.Controllers;


import com.example.demo.RequestDto.BookDto;
import com.example.demo.RequestDto.BookIdDto;
import com.example.demo.RequestDto.BookIssueDto;
import com.example.demo.RequestDto.BookSubmitDto;
import com.example.demo.ResponseDto.BookResponseDto;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;


    @PostMapping("add")
    public String addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }
    @PutMapping("issueBook")
    public String issueBook(@RequestBody BookIssueDto bookIssueDto){
        return bookService.issueBook(bookIssueDto);
    }
    @PutMapping("submitBook")
    public String submitBook(@RequestBody BookSubmitDto bookSubmitDto){
        return bookService.submitBook(bookSubmitDto);
    }
    @GetMapping("getBook")
    public BookResponseDto getBook(@RequestBody BookIdDto bookIdDto){
        return bookService.getBook(bookIdDto);
    }

}
