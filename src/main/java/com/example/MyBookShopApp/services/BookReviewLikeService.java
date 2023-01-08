package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.BookReviewLikeDto;
import com.example.MyBookShopApp.dto.BookReviewLikeDtoMapping;
import com.example.MyBookShopApp.repositories.BookReviewLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReviewLikeService {

    private BookReviewLikeDtoMapping bookReviewLikeDtoMapping;

    private BookReviewLikeRepository bookReviewLikeRepository;

    @Autowired
    public BookReviewLikeService(BookReviewLikeDtoMapping bookReviewLikeDtoMapping, BookReviewLikeRepository bookReviewLikeRepository) {
        this.bookReviewLikeDtoMapping = bookReviewLikeDtoMapping;
        this.bookReviewLikeRepository = bookReviewLikeRepository;
    }

    public BookReviewLikeDto postReviewLike(BookReviewLikeDto bookReviewLikeDto){
        bookReviewLikeDto.setBookReviewLikesCount(bookReviewLikeDto.getBookReviewLikesCount() + 1);
        return bookReviewLikeDtoMapping.mapToBookReviewLikeDto(bookReviewLikeRepository.save(bookReviewLikeDtoMapping.mapToBookReviewLike(bookReviewLikeDto)));
    }

    public BookReviewLikeDto postReviewDislike(BookReviewLikeDto bookReviewLikeDto){
        bookReviewLikeDto.setBookReviewDislikesCount(bookReviewLikeDto.getBookReviewDislikesCount() + 1);
        return bookReviewLikeDtoMapping.mapToBookReviewLikeDto(bookReviewLikeRepository.save(bookReviewLikeDtoMapping.mapToBookReviewLike(bookReviewLikeDto)));
    }

    public List<BookReviewLikeDto> getBookReviewLikes() {
        return bookReviewLikeRepository.findAll()
                .stream()
                .map(BookReviewLikeDtoMapping::mapToBookReviewLikeDto)
                .collect(Collectors.toList());
    }
}
