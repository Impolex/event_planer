package com.example.letseventdemo.api.model;

import com.example.letseventdemo.api.model.id_classes.GroupMemberId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "group_member")
@IdClass(GroupMemberId.class)
public class GroupMember {

    @Id
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User member;

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "`group`", referencedColumnName = "id")
    private Group group;

    @Column(name = "role")
    private String role;

    public GroupMember() {

    }

    public GroupMember(Group group, User user, String role) {
       this.member = user;
       this.group = group;
       this.role = role;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
