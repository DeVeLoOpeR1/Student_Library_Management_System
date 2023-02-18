package com.example.demo.ResponseDto;

import com.example.demo.Enums.Genre;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class BookResponseDto
{
    private int id;
    private String name;
    private String writer;
    //@Enumerated(value = EnumType.STRING)
    private Genre genre;
    private int authorId;

    public BookResponseDto() {
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
