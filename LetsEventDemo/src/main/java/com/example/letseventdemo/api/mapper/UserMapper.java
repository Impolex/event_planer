package com.example.letseventdemo.api.mapper;

import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.model.dto.UserDTO;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
}
