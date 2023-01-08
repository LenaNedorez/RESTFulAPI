package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entities.Book;
import com.example.MyBookShopApp.entities.PostponedBook;
import com.example.MyBookShopApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostponedRepository extends JpaRepository<PostponedBook, Integer> {
    PostponedBook findByUserAndBook(Book book, User user);
}
