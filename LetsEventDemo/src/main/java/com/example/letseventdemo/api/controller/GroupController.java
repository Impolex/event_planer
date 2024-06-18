package com.example.letseventdemo.api.controller;

import com.example.letseventdemo.api.controller.exception.NoPermissionException;
import com.example.letseventdemo.api.mapper.GroupMapper;
import com.example.letseventdemo.api.model.Group;
import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.model.dto.GroupDTO;
import com.example.letseventdemo.service.GroupService;
import com.example.letseventdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/group")
@RestController
public class GroupController {

    private GroupService groupService;
    private UserService userService;

    @Autowired
    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<GroupDTO> getGroups() {
        return groupService.getGroups().stream().map(GroupMapper::toGroupDTP).toList();
    }

    @GetMapping("/{id}")
    public Optional<GroupDTO> getGroup(@PathVariable("id") Integer id) throws NoPermissionException {
        Optional<Group> group = groupService.getGroup(id);
        if (group.isPresent()) {
            return Optional.of(GroupMapper.toGroupDTP(group.get()));
        }
        throw new NoPermissionException("group does not exist");
    }

    @PostMapping("")
    public GroupDTO postGroup(Integer ownerId, String name) throws NoPermissionException {
        Optional<User> user = userService.getUser(ownerId);
        if (user.isPresent()) {
            Group group = new Group(user.get(), name);
            Group created = groupService.saveGroup(group);
            GroupDTO dto = GroupMapper.toGroupDTP(created);
            return dto;
        }
        throw new NoPermissionException("this user does not exist");
    }

    @PatchMapping("/{id}")
    public Optional<GroupDTO> patchGroup(@PathVariable("id") Integer id, Optional<String> name) {
        Optional<Group> groupOptional = groupService.getGroup(id);
        if (groupOptional.isPresent()) {
            Group group = groupOptional.get();
            name.ifPresent(group::setName);
            groupService.saveGroup(group);
            return Optional.of(GroupMapper.toGroupDTP(group));
        } else return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable("id") Integer id) throws NoPermissionException {
        if (!groupService.deleteGroup(id)) {
            throw new NoPermissionException("this event does not exist");
        }
    }

    @PostMapping("/{id}/add")
    public void postAdd(@PathVariable("id") Integer id, Integer userID) throws NoPermissionException {
        Optional<Group> group = groupService.getGroup(id);
        if (group.isEmpty()) {
            throw new NoPermissionException("this event does not exist");
        }
        Optional<User> user = userService.getUser(userID);
        if (user.isEmpty()) {
            throw new NoPermissionException("this user does not exist");
        }
        groupService.addMember(group.get(), user.get());
    }

    @PostMapping("/{id}/remove")
    public void postRemove(@PathVariable("id") Integer id, Integer userID) throws NoPermissionException {
        Optional<Group> event = groupService.getGroup(id);
        if (event.isEmpty()) {
            throw new NoPermissionException("this event does not exist");
        }
        Optional<User> user = userService.getUser(userID);
        if (user.isEmpty()) {
            throw new NoPermissionException("this user does not exist");
        }
        groupService.removeMember(event.get(), user.get());
    }

}
