package com.example.MyBookShopApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "postponed_book")
public class PostponedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    private Boolean kept;

    public PostponedBook() {
    }

    public PostponedBook(Integer id, User user, Book book, Boolean kept) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.kept = kept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Boolean getKept() {
        return kept;
    }

    public void setKept(Boolean kept) {
        this.kept = kept;
    }
}
