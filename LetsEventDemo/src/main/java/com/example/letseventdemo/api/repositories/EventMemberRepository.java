package com.example.letseventdemo.api.repositories;

import com.example.letseventdemo.api.model.EventMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventMemberRepository extends JpaRepository<EventMember, Integer> {
}
