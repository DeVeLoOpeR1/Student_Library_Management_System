package com.example.demo.RequestDto;

import com.example.demo.Enums.Genre;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class BookDto {

    private String name;

    private String writer;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    //we collibing attribute of two entity to make a new data transfer object to be there

    private int authorId;

    public BookDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
