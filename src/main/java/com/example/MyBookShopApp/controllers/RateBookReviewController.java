package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
import com.example.MyBookShopApp.dto.BookReviewDto;
import com.example.MyBookShopApp.dto.BookReviewLikeDto;
import com.example.MyBookShopApp.errs.BookReviewLikeWrongParameterException;
import com.example.MyBookShopApp.services.BookReviewLikeService;
import com.example.MyBookShopApp.services.BookReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RateBookReviewController {

    private BookReviewLikeService bookReviewLikeService;

    private BookReviewService bookReviewService;

    @Autowired
    public RateBookReviewController(BookReviewLikeService bookReviewLikeService, BookReviewService bookReviewService) {
        this.bookReviewLikeService = bookReviewLikeService;
        this.bookReviewService = bookReviewService;
    }

    @PostMapping("/api/rateBookReview/{reviewId}")
    @ApiOperation("post like or dislike of a book review")
    public ResponseEntity<BookReviewLikeDto> rateBookReview(@PathVariable("bookReviewId") Integer bookReviewId, @RequestParam Byte value) throws BookReviewLikeWrongParameterException {

        BookReviewDto bookReviewDto = bookReviewService.getBookReviewById(bookReviewId);

        if (value == 1){
            return ResponseEntity.ok(bookReviewLikeService.postReviewLike(new BookReviewLikeDto(bookReviewDto, value)));
        } else if(value == -1) {
            return ResponseEntity.ok(bookReviewLikeService.postReviewDislike(new BookReviewLikeDto(bookReviewDto, value)));
        } else {
            throw new BookReviewLikeWrongParameterException("book review rate should be 1 or -1");
        }
    }

    @ExceptionHandler(BookReviewLikeWrongParameterException.class)
    public ResponseEntity<ApiResponse<BookReviewLikeDto>> handleBookReviewLikeWrongParameterException(Exception exception) {
        return new ResponseEntity<>(new ApiResponse<BookReviewLikeDto>(HttpStatus.BAD_REQUEST, "Bad parameter value...", exception)
                , HttpStatus.BAD_REQUEST);
    }
}
