package com.example.demo.Models;


import com.example.demo.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    //for foreign key connection with the parent table

    @OneToOne
    @JoinColumn
    private Student student1; //this variable name taken by parent class


    //bidirectional mapping with the book entity
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> issued = new ArrayList<>(); //many book is issued there


    //bidirectional mapping of the card and transaction i sto be therer
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>(); //better to initalize it here

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }


    public List<Book> getIssued() {
        return issued;
    }

    public void setIssued(List<Book> issued) {
        this.issued = issued;
    }



    public Card() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Student getStudent() {
        return student1;
    }

    public void setStudent(Student student) {
        this.student1 = student;
    }
}
