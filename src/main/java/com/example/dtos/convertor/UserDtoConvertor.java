package com.example.dtos.convertor;


import com.example.dtos.UserDto;
import com.example.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class UserDtoConvertor {

    public UserDto convertToUserDto(User user){
        return new UserDto(
                user.getEmail()
        );

    }


}
