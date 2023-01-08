package com.example.MyBookShopApp.dto;

public class PostponedBookDto {

    private Integer id;

    private UserDto userDto;

    private BookDto bookDto;

    private Boolean kept;

    public PostponedBookDto() {
    }

    public PostponedBookDto(Integer id, UserDto userDto, BookDto bookDto, Boolean kept) {
        this.id = id;
        this.userDto = userDto;
        this.bookDto = bookDto;
        this.kept = kept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public Boolean getKept() {
        return kept;
    }

    public void setKept(Boolean kept) {
        this.kept = kept;
    }
}
