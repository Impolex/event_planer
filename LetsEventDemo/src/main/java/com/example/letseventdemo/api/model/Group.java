package com.example.letseventdemo.api.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "groups")
public class Group {
    //private List<User> members;
    //private List<User> admins;
    //private User owner;

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    List<GroupMember> members = new ArrayList<>();

    //Constructor
    public Group(){

    }

    public Group(User owner, String name) {
        this.name = name;
        members.add(new GroupMember(this, owner, "owner"));
    }

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroupMember> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMember> members) {
        this.members = members;
    }
    public GroupMember addMember(User user){
        GroupMember member = new GroupMember(this, user, "member");
        members.add(member);
        return member;
    }

    /**
     * Closes the UI of the specified user, removes the UI from the UIs list and removes the user from the participants list.
     * @param user The user instance to be removed
     */
    public Optional<GroupMember> removeMember(User user) {
        Optional<GroupMember> member = members.stream().filter(u -> u.getMember().getUserId() == user.getUserId()).findFirst();
        return member;
    }
}
