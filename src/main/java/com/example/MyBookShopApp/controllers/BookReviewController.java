package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entities.Book;
import com.example.MyBookShopApp.services.BookReviewService;
import com.example.MyBookShopApp.entities.User;
import com.example.MyBookShopApp.dto.BookReviewDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class BookReviewController {

    private BookReviewService bookReviewService;

    public BookReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    @PostMapping("/api/bookReview/{bookId}")
    @ApiOperation("post review of a book")
    public ResponseEntity<BookReviewDto> reviewBook(@RequestParam LocalDateTime dateTime, @PathVariable("bookId") Book book, @RequestParam User user, @RequestParam String text) {
        return ResponseEntity.ok(bookReviewService.postBookReview(dateTime, book, user, text));
    }
}
