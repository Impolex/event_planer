package com.example.letseventdemo.api.model.id_classes;

import java.io.Serializable;
import java.util.Objects;

public class EventMemberId implements Serializable {
    private int member;
    private int event;

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventMemberId that = (EventMemberId) o;
        return member == that.member && event == that.event;
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, event);
    }
}
