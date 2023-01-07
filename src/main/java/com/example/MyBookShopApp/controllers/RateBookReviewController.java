package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
import com.example.MyBookShopApp.errs.BookReviewLikeWrongParameterException;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RateBookReviewController {

    private BookReviewLikeService bookReviewLikeService;


    @PostMapping("/api/rateBookReview/{reviewId}")
    @ApiOperation("post like or dislike of a book review")
    public ResponseEntity<BookReviewLike> rateBookReview(@PathVariable("bookReview") BookReview bookReview, @RequestParam Byte value) throws BookReviewLikeWrongParameterException {

        if (value == 1){
            return ResponseEntity.ok(bookReviewLikeService.postReviewLike(new BookReviewLike(bookReview, value)));
        } else if(value == -1) {
            return ResponseEntity.ok(bookReviewLikeService.postReviewDislike(new BookReviewLike(bookReview, value)));
        } else {
            throw new BookReviewLikeWrongParameterException("book review rate should be 1 or -1");
        }
    }

    @ExceptionHandler(BookReviewLikeWrongParameterException.class)
    public ResponseEntity<ApiResponse<BookReviewLike>> handleBookReviewLikeWrongParameterException(Exception exception) {
        return new ResponseEntity<>(new ApiResponse<BookReviewLike>(HttpStatus.BAD_REQUEST, "Bad parameter value...", exception)
                , HttpStatus.BAD_REQUEST);
    }
}
