package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entities.PostponedBook;
import org.springframework.stereotype.Service;

@Service
public class PostponedBookDtoMapping {

    public static PostponedBookDto mapToPostponedBookDto(PostponedBook postponedBook){
        PostponedBookDto postponedBookDto = new PostponedBookDto();
        postponedBookDto.setId(postponedBook.getId());
        postponedBookDto.setBookDto(BookDtoMapping.toBookDto(postponedBook.getBook()));
        postponedBookDto.setUserDto(UserDtoMapping.toUserDto(postponedBook.getUser()));
        postponedBookDto.setKept(postponedBook.getKept());
        return postponedBookDto;
    }

    public static PostponedBook mapToPostponedBook(PostponedBookDto postponedBookDto){
        PostponedBook postponedBook = new PostponedBook();
        postponedBook.setId(postponedBookDto.getId());
        postponedBook.setBook(BookDtoMapping.toBook(postponedBookDto.getBookDto()));
        postponedBook.setUser(UserDtoMapping.toUser(postponedBookDto.getUserDto()));
        postponedBook.setKept(postponedBookDto.getKept());
        return postponedBook;
    }
}
