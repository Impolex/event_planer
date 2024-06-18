package com.example.letseventdemo.api.repositories;

import com.example.letseventdemo.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users u where username = :name", nativeQuery = true)
    Optional<User> findByName(@Param("name") String name);
}
