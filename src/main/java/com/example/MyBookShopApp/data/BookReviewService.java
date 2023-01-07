package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookReviewService {

    private BookReviewRepository bookReviewRepository;

    @Autowired
    public BookReviewService(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    public List<BookReview> getAllReviews() {
        return bookReviewRepository.findAll();

    }

    public BookReview postBookReview(LocalDateTime dateTime, Book book, User user, String text) {
        return bookReviewRepository.save(new BookReview(dateTime, book, user, text));
    }
}
