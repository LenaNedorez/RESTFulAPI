package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.*;
import com.example.MyBookShopApp.repositories.PostponedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostponedService {

    private PostponedBookDtoMapping postponedBookDtoMapping;

    private PostponedRepository postponedRepository;

    @Autowired
    public PostponedService(PostponedBookDtoMapping postponedBookDtoMapping, PostponedRepository postponedRepository) {
        this.postponedBookDtoMapping = postponedBookDtoMapping;
        this.postponedRepository = postponedRepository;
    }

    public PostponedBookDto save(PostponedBookDto postponedBookDto){
        return postponedBookDtoMapping.mapToPostponedBookDto(postponedRepository.save(postponedBookDtoMapping.mapToPostponedBook(postponedBookDto)));
    }

    public List<PostponedBookDto> getAllPostponedBooks() {
        return postponedRepository.findAll()
                .stream()
                .map(PostponedBookDtoMapping::mapToPostponedBookDto)
                .collect(Collectors.toList());
    }

    public PostponedBookDto findByUserDtoAndBookDto (UserDto userDto, BookDto bookDto){
        return postponedBookDtoMapping.mapToPostponedBookDto(postponedRepository.findByUserAndBook(BookDtoMapping.toBook(bookDto), UserDtoMapping.toUser(userDto)));
    }
}
