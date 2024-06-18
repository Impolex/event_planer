package com.example.letseventdemo.api.repositories;

import com.example.letseventdemo.api.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
