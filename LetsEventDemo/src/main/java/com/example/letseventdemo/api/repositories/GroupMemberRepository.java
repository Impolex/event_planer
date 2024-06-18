package com.example.letseventdemo.api.repositories;

import com.example.letseventdemo.api.model.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Integer> {
}
