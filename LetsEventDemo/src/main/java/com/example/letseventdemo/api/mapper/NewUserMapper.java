package com.example.letseventdemo.api.mapper;

import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.model.dto.UserDTO;

public class NewUserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }
}
