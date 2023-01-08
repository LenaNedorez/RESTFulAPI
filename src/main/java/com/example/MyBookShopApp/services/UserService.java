package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.UserDto;
import com.example.MyBookShopApp.dto.UserDtoMapping;
import com.example.MyBookShopApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDtoMapping userDtoMapping;

    private UserRepository userRepository;

    @Autowired
    public UserService(UserDtoMapping userDtoMapping, UserRepository userRepository) {
        this.userDtoMapping = userDtoMapping;
        this.userRepository = userRepository;
    }

    public UserDto findUserById(Integer id) {
        return UserDtoMapping.toUserDto(userRepository.findUserById(id));
    }
}
