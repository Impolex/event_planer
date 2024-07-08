package com.example.letseventdemo.api.controller;

import com.example.letseventdemo.api.component.JwtUtil;
import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.service.MyUserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class AuthController {

    MyUserService userService;

    JwtUtil jwtUtil;

    public AuthController(MyUserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    //for security reasons this should rather be a POST
    @GetMapping("/login")
    public String getLogin(Optional<String> username, Optional<String> password) {
        if (username.isEmpty()) {
            System.out.println("no username");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no username given");
        }
        if (password.isEmpty()) {
            System.out.println("no username");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no password given");
        }
        String name = username.get();
        if (userService.getUser(name).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user does not exist");
        }
        User user = userService.login(name, password.get());

        return jwtUtil.generateJWT(user);
    }

    @PostMapping("/signup")
    public String postSignup(Optional<String> username, Optional<String> password) {
        if (username.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no username given");
        }
        if (password.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no password given");
        }
        String name = username.get();
        if (userService.getUser(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username is already taken");
        }
        User user = userService.create(username.get(), password.get());
        return jwtUtil.generateJWT(user);
    }

    @DeleteMapping("/delete")
    public void delete() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Optional<User> user = userService.getUser(username);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(username);
    }

    @GetMapping("/me")
    public String getMe() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

}
