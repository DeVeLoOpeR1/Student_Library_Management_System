package com.example.demo.Models;

import com.example.demo.Enums.Status;
import com.example.demo.Enums.Type;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private String id = UUID.randomUUID().toString();

    @CreationTimestamp
    private Date creationOn;


    @Enumerated(value = EnumType.STRING)
    private Type type;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    //transaction is also the child of the both book and the card entity so we need to specify that
    //relationship between that is the many things to do or not

    //transaction mapping with the book entity
    @ManyToOne
    @JoinColumn
    private Book book;

    //transaction mapping with the card entity to make it a foreign key in this table
    @ManyToOne
    @JoinColumn
    private Card card;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationOn() {
        return creationOn;
    }

    public void setCreationOn(Date creationOn) {
        this.creationOn = creationOn;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
