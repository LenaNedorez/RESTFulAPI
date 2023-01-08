package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entities.Book;
import com.example.MyBookShopApp.services.BookRateService;
import com.example.MyBookShopApp.entities.User;
import com.example.MyBookShopApp.dto.BookRateDto;
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
    public ResponseEntity<BookRateDto> rateBook(@PathVariable("bookId") Book bookId, @RequestParam User userId, @RequestParam Byte value) {
        return ResponseEntity.ok(bookRateService.postBookRate(new BookRateDto(bookId, userId, value)));
    }
}
