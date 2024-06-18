package com.example.letseventdemo.api.model.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class GroupMemberId implements Serializable {

    private int member;
    private int group;

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMemberId that = (GroupMemberId) o;
        return member == that.member && group == that.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, group);
    }
}
