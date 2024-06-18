package com.example.letseventdemo.api.model.dto;

import com.example.letseventdemo.api.model.GroupMember;

import java.util.ArrayList;
import java.util.List;

public record GroupDTO(
    Integer id,
    String name,
    List<GroupMember> members
        ) {
}
