package com.example.letseventdemo.api.repositories;

import com.example.letseventdemo.api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
