package com.example.letseventdemo.api.mapper;

import com.example.letseventdemo.api.model.Group;
import com.example.letseventdemo.api.model.GroupMember;
import com.example.letseventdemo.api.model.dto.GroupDTO;

import java.util.List;

public class GroupMapper {

    public static GroupDTO toGroupDTO(Group group) {
        Integer id = group.getId();
        String name = group.getName();
        List<GroupMember> members = group.getMembers();
        GroupDTO dto = new GroupDTO(id, name, members);
        return dto;
    }

}
