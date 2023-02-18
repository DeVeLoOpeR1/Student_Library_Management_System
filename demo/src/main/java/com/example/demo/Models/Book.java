package com.example.demo.Models;

import com.example.demo.Enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String writer;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    // Add Foreign Key in Book table taken it form the author table
    // this is the one step for the uni direction al mapping can be done by that things
    @ManyToOne
    @JoinColumn
    private Author author;

    // for making a foreign key of the card entity
    @ManyToOne
    @JoinColumn
    private Card card; // this variable is used for the reference there to be

    // for bidirectional mapping with the transaction
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transaction = new ArrayList<>(); //always a good prractise to initalize it there


    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book() {

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
