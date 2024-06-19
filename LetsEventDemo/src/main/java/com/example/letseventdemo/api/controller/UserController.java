package com.example.letseventdemo.api.controller;

import com.example.letseventdemo.api.mapper.NewUserMapper;
import com.example.letseventdemo.api.mapper.UserMapper;
import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.model.dto.UserDTO;
import com.example.letseventdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{ids}")
    public List<UserDTO> getUser(@PathVariable("ids") List<Integer> users) {
        return users.stream().map(u -> userService.getUser(u)).filter(Optional::isPresent).map(Optional::get).map(NewUserMapper::toUserDTO).toList();
    }

    @GetMapping("")
    public Optional<UserDTO> findByName(String name) {
        return userService.getUser(name).map(NewUserMapper::toUserDTO);
    }

}
