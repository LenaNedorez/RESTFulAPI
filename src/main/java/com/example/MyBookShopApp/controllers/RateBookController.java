package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookRate;
import com.example.MyBookShopApp.data.BookRateService;
import com.example.MyBookShopApp.data.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RateBookController {

    private BookRateService bookRateService;

    public RateBookController(BookRateService bookRateService) {
        this.bookRateService = bookRateService;
    }

    @PostMapping("/api/rateBook/{bookId}")
    @ApiOperation("post rate of a book")
    public ResponseEntity<BookRate> rateBook(@PathVariable("bookId") Book bookId, @RequestParam User userId, @RequestParam Byte value) {
        return ResponseEntity.ok(bookRateService.postBookRate(new BookRate(bookId, userId, value)));
    }
}
