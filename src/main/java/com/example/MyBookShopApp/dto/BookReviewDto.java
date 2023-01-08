package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entities.Book;
import com.example.MyBookShopApp.entities.User;

import java.time.LocalDateTime;

public class BookReviewDto {

    private Integer id;

    private LocalDateTime dateTime;

    private Book book;

    private User user;

    private String text;

    public BookReviewDto() {
    }

    public BookReviewDto(LocalDateTime dateTime, Book book, User user, String text) {
        this.dateTime = dateTime;
        this.book = book;
        this.user = user;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
