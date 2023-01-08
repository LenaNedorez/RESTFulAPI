package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.BookReviewDto;
import com.example.MyBookShopApp.dto.BookReviewDtoMapping;
import com.example.MyBookShopApp.entities.Book;
import com.example.MyBookShopApp.entities.BookReview;
import com.example.MyBookShopApp.entities.User;
import com.example.MyBookShopApp.repositories.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReviewService {

    private BookReviewDtoMapping bookReviewDtoMapping;

    private BookReviewRepository bookReviewRepository;

    @Autowired
    public BookReviewService(BookReviewDtoMapping bookReviewDtoMapping, BookReviewRepository bookReviewRepository) {
        this.bookReviewDtoMapping = bookReviewDtoMapping;
        this.bookReviewRepository = bookReviewRepository;
    }

    public BookReviewDto getBookReviewById(Integer bookReviewId) {
        return bookReviewDtoMapping.mapToBookReviewDto(bookReviewRepository.findOne(bookReviewId));
    }

    public List<BookReviewDto> getAllReviews() {
        return bookReviewRepository.findAll()
                .stream()
                .map(BookReviewDtoMapping::mapToBookReviewDto)
                .collect(Collectors.toList());
    }

    public BookReviewDto postBookReview(LocalDateTime dateTime, Book book, User user, String text) {
        return bookReviewDtoMapping.mapToBookReviewDto(bookReviewRepository.save(new BookReview(dateTime, book, user, text)));
    }
}
