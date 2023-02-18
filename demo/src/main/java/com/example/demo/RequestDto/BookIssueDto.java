package com.example.demo.RequestDto;

public class BookIssueDto {
    private int bookId;
    private int cardId;

    public BookIssueDto() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
