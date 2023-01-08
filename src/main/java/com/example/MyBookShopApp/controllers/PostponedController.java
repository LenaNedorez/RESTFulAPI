package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.dto.PostponedBookDto;
import com.example.MyBookShopApp.dto.UserDto;
import com.example.MyBookShopApp.services.BookService;
import com.example.MyBookShopApp.services.PostponedService;
import com.example.MyBookShopApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostponedController {

    private PostponedService postponedService;
    private UserService userService;
    private BookService bookService;

    @Autowired
    public PostponedController(PostponedService postponedService, UserService userService, BookService bookService) {
        this.postponedService = postponedService;
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/postponedBooks")
    public List<PostponedBookDto> getAllPostponedBooks(){
        return postponedService.getAllPostponedBooks();
    }

    @PostMapping("/postponed")
    public PostponedBookDto postponed(Integer userId, Integer bookId){

        UserDto userDto = userService.findUserById(userId);
        BookDto bookDto = bookService.findBookById(bookId);

        PostponedBookDto postponedBookDto = postponedService.findByUserDtoAndBookDto(userDto, bookDto);
        if (postponedBookDto.getKept() == false){
            postponedBookDto.setKept(true);
        } else {postponedBookDto.setKept(false);}
        return postponedService.save(postponedBookDto);
    }
}
