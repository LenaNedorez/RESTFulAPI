package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookReviewLikeService {

    private BookReviewLike bookReviewLike;
    private BookReviewLikeRepository bookReviewLikeRepository;

    @Autowired
    public BookReviewLikeService(BookReviewLike bookReviewLike) {
        this.bookReviewLike = bookReviewLike;
    }

    @Autowired
    public BookReviewLikeService(BookReviewLikeRepository BookReviewLikeRepository) {
        this.bookReviewLikeRepository = BookReviewLikeRepository;
    }

    public BookReviewLike postReviewLike(BookReviewLike bookReviewLike){
        bookReviewLike.setBookReviewLikesCount(bookReviewLike.getBookReviewLikesCount() + 1);
        return bookReviewLikeRepository.save(bookReviewLike);
    }

    public BookReviewLike postReviewDislike(BookReviewLike bookReviewLike){
        bookReviewLike.setBookReviewDislikesCount(bookReviewLike.getBookReviewDislikesCount() + 1);
        return bookReviewLikeRepository.save(bookReviewLike);
    }

    public List<BookReviewLike> getBookReviewLikes() {
        return bookReviewLikeRepository.findAll();
    }
}
