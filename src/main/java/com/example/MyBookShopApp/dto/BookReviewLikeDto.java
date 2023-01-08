package com.example.MyBookShopApp.dto;

public class BookReviewLikeDto {

    private Integer id;

    private BookReviewDto bookReviewDto;

    private Byte value;

    private static Integer bookReviewLikesCount = 0;

    private static Integer bookReviewDislikesCount = 0;

    public BookReviewLikeDto() {
    }

    public BookReviewLikeDto(BookReviewDto bookReviewDto, Byte value) {
        this.bookReviewDto = bookReviewDto;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BookReviewDto getBookReviewDto() { return bookReviewDto; }

    public void setBookReviewDto(BookReviewDto bookReviewDto) { this.bookReviewDto = bookReviewDto; }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public static Integer getBookReviewLikesCount() {
        return bookReviewLikesCount;
    }

    public static void setBookReviewLikesCount(Integer bookReviewLikesCount) {
        BookReviewLikeDto.bookReviewLikesCount = bookReviewLikesCount;
    }

    public static Integer getBookReviewDislikesCount() {
        return bookReviewDislikesCount;
    }

    public static void setBookReviewDislikesCount(Integer bookReviewDislikesCount) {
        BookReviewLikeDto.bookReviewDislikesCount = bookReviewDislikesCount;
    }
}
