package com.example.letseventdemo.service;

import com.example.letseventdemo.api.model.*;
import com.example.letseventdemo.api.repositories.GroupMemberRepository;
import com.example.letseventdemo.api.repositories.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    GroupRepository groupRepository;
    GroupMemberRepository groupMemberRepository;

    public GroupService(GroupRepository groupRepository, GroupMemberRepository groupMemberRepository) {
        this.groupRepository = groupRepository;
        this.groupMemberRepository = groupMemberRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(Integer id) {
        return groupRepository.findById(id);
    }

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public void addMember(Group group, User user) {
        GroupMember member = group.addMember(user);
        groupMemberRepository.save(member);
        groupRepository.save(group);
    }

    public boolean deleteGroup(Integer id) {
        Optional<Group> event = groupRepository.findById(id);
        if (event.isPresent()) {
            groupRepository.delete(event.get());
            return true;
        }
        return false;
    }

    public void removeMember(Group group, User user) {
        Optional<GroupMember> member = group.removeMember(user);
        if (member.isPresent()) {
            groupMemberRepository.delete(member.get());
        }
    }
}
