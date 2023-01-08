package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserDtoMapping {

    public static UserDto toUserDto (User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        return userDto;
    }

    public static User toUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        return user;
    }
}
