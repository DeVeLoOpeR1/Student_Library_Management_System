package com.example.demo.ResponseDto;

import java.util.ArrayList;
import java.util.List;

public class BookAssignedResponseDto {
    // to show book assigned to a student
    private int id;
    private String name;
    // list of the book that are assigned to
    private List<BookResponseDto> bookResponseDtoList = new ArrayList<>();

    public BookAssignedResponseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookResponseDto> getBookResponseDtoList() {
        return bookResponseDtoList;
    }

    public void setBookResponseDtoList(List<BookResponseDto> bookResponseDtoList) {
        this.bookResponseDtoList = bookResponseDtoList;
    }
}
