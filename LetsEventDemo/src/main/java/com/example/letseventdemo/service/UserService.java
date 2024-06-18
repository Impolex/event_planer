package com.example.letseventdemo.service;

import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUser(String name) {
        return userRepository.findByName(name);
    }

    public User create(String username, String password) {
        byte[] salt = new byte[32];
        Random r = new Random();
        r.nextBytes(salt);
        byte[] hash = calculateHash(password, salt);
        String hashBase64 = Base64.getEncoder().encodeToString(hash);
        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        User user = new User(username, hashBase64, saltBase64);
        userRepository.save(user);
        return user;
    }

    public User login(String username, String password) {
        Optional<User> userOptional = userRepository.findByName(username);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no user with this username found");
        }
        User user = userOptional.get();
        byte[] salt = Base64.getDecoder().decode(user.getSalt());
        byte[] hash = Base64.getDecoder().decode(user.getPassword());
        byte[] hashCalculated = calculateHash(password, salt);

        if (Arrays.equals(hash, hashCalculated)) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "wrong password");
        }
    }

    private byte[] calculateHash(String password, byte[] salt) {
        byte[] pw = password.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] combined = new byte[salt.length + pw.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(pw, 0, combined, salt.length, pw.length);
            byte[] hash = md.digest(combined);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
