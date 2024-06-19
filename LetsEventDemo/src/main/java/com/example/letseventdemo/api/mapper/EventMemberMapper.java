package com.example.letseventdemo.api.mapper;

import com.example.letseventdemo.api.model.EventMember;
import com.example.letseventdemo.api.model.dto.EventMemberDTO;

public class EventMemberMapper {
    public static EventMemberDTO toEventMapperDTO(EventMember eventMember) {
        return new EventMemberDTO(eventMember.getMember().getUserId(), eventMember.getMember().getUserName(), eventMember.getRole());
    }
}
