package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entities.BookReviewLike;
import org.springframework.stereotype.Service;

@Service
public class BookReviewLikeDtoMapping {

    public static BookReviewLikeDto mapToBookReviewLikeDto(BookReviewLike bookReviewLike){
        BookReviewLikeDto bookReviewLikeDto = new BookReviewLikeDto();
        bookReviewLikeDto.setId(bookReviewLike.getId());
        bookReviewLikeDto.setBookReviewDto(BookReviewDtoMapping.mapToBookReviewDto(bookReviewLike.getBookReview()));
        bookReviewLikeDto.setValue(bookReviewLike.getValue());
        return bookReviewLikeDto;
    }

    public static BookReviewLike mapToBookReviewLike(BookReviewLikeDto bookReviewLikeDto){
        BookReviewLike bookReviewLike = new BookReviewLike();
        bookReviewLike.setId(bookReviewLikeDto.getId());
        bookReviewLike.setBookReview(BookReviewDtoMapping.mapToBookReview(bookReviewLikeDto.getBookReviewDto()));
        bookReviewLike.setValue(bookReviewLikeDto.getValue());
        return bookReviewLike;
    }
}
