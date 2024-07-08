package com.example.letseventdemo.api.controller;

import com.example.letseventdemo.api.mapper.GroupMapper;
import com.example.letseventdemo.api.model.Group;
import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.model.dto.GroupDTO;
import com.example.letseventdemo.service.GroupService;
import com.example.letseventdemo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/group")
@RestController
public class GroupController {

    private GroupService groupService;
    private MyUserService userService;

    @Autowired
    public GroupController(GroupService groupService, MyUserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<GroupDTO> getGroups() {
        return groupService.getGroups().stream().map(GroupMapper::toGroupDTO).toList();
    }

    @GetMapping("/{id}")
    public Optional<GroupDTO> getGroup(@PathVariable("id") Integer id) {
        Optional<Group> group = groupService.getGroup(id);
        if (group.isPresent()) {
            return Optional.of(GroupMapper.toGroupDTO(group.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "group does not exist");
    }

    @PostMapping("")
    public GroupDTO postGroup(Integer ownerId, String name) {
        Optional<User> user = userService.getUser(ownerId);
        if (user.isPresent()) {
            Group group = new Group(user.get(), name);
            Group created = groupService.saveGroup(group);
            GroupDTO dto = GroupMapper.toGroupDTO(created);
            return dto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user does not exist");
    }

    @PatchMapping("/{id}")
    public Optional<GroupDTO> patchGroup(@PathVariable("id") Integer id, Optional<String> name) {
        Optional<Group> groupOptional = groupService.getGroup(id);
        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            name.ifPresent(group::setName);
            groupService.saveGroup(group);
            return Optional.of(GroupMapper.toGroupDTO(group));
        } else return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Integer id) {
        if (!groupService.deleteGroup(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "group does not exist");
        }
    }

    @PostMapping("/{id}/add")
    public void postAdd(@PathVariable("id") Integer id, Integer userID) {
        Group group = checkGroup(id);
        User user = checkUser(userID);
        groupService.addMember(group, user);
    }

    @PostMapping("/{id}/remove")
    public void postRemove(@PathVariable("id") Integer id, Integer userID) {
        Group group = checkGroup(id);
        User user = checkUser(userID);
        groupService.removeMember(group, user);
    }

    private Group checkGroup(Integer id) {
        Optional<Group> group = groupService.getGroup(id);
        if (group.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "group does not exist");
        }
        return group.get();
    }

    private User checkUser(Integer id) {
        Optional<User> user = userService.getUser(id);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user does not exist");
        }
        return user.get();
    }
}