package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entities.Book;
import org.springframework.stereotype.Service;

@Service
public class BookDtoMapping {

    public static BookDto toBookDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setPubDate(book.getPubDate());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsBestseller(book.getIsBestseller());
        bookDto.setSlug(book.getSlug());
        bookDto.setTitle(book.getTitle());
        bookDto.setImage(book.getImage());
        bookDto.setBookFileList(book.getBookFileList());
        bookDto.setDescription(book.getDescription());
        bookDto.setPriceOld(book.getPriceOld());
        bookDto.setPrice(book.getPrice());
        return bookDto;
    }

    public static Book toBook (BookDto bookDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setPubDate(bookDto.getPubDate());
        book.setAuthor(bookDto.getAuthor());
        book.setIsBestseller(bookDto.getIsBestseller());
        book.setSlug(bookDto.getSlug());
        book.setTitle(bookDto.getTitle());
        book.setImage(bookDto.getImage());
        book.setBookFileList(bookDto.getBookFileList());
        book.setDescription(bookDto.getDescription());
        book.setPriceOld(bookDto.getPriceOld());
        book.setPrice(bookDto.getPrice());
        return book;
    }
}
