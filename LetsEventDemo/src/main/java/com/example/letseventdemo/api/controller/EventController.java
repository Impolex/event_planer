package com.example.letseventdemo.api.controller;

import com.example.letseventdemo.api.mapper.EventMapper;
import com.example.letseventdemo.api.model.Event;
import com.example.letseventdemo.api.model.User;
import com.example.letseventdemo.api.model.dto.EventDTO;
import com.example.letseventdemo.service.EventService;
import com.example.letseventdemo.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/event")
@RestController
public class EventController {

    private EventService eventService;
    private MyUserService userService;

    @Autowired
    public EventController(EventService eventService, MyUserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<EventDTO> getEvents() {
        String name = getUsername();
        return eventService
                .getEvents()
                .stream()
                .filter(event -> event.isMember(name))
                .map(EventMapper::toEventDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<EventDTO> getEvent(@PathVariable("id") Integer id) {
        String name = getUsername();
        Optional<Event> requested = eventService.getEvent(id);
        if (requested.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this event does not exist");
        }
        Event event = requested.get();
        if (event.isMember(name)) {
            return Optional.of(EventMapper.toEventDTO(event));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/")
    public EventDTO postEvent(String title, String description, String place, String date) {
        String name = getUsername();
        Optional<User> user = userService.getUser(name);
        if (user.isPresent()) {
            Event event = new Event(title, description/*, place*/, date);
            Event created = eventService.saveEvent(event);
            eventService.addMember(event, user.get(), "host");
            EventDTO dto = EventMapper.toEventDTO(created);
            return dto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public Optional<EventDTO> patchEvent(
            @PathVariable("id") Integer id,
            Optional<Integer> hostID,
            Optional<String> title,
            Optional<String> description,
            Optional<String> place,
            Optional<String> date
    ) {
        Event event = checkEvent(id);
        title.ifPresent(event::setTitle);
        description.ifPresent(event::setDescription);
        date.ifPresent(event::setDate);
        eventService.saveEvent(event);
        EventDTO dto = EventMapper.toEventDTO(event);
        return Optional.of(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Integer id) {
        checkEvent(id);
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/add")
    public void postInvite(@PathVariable("id") Integer id, Integer userID) {
        Event event = checkEvent(id);
        Optional<User> user = userService.getUser(userID);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this user does not exist");
        }
        eventService.addMember(event, user.get());
    }

    @PostMapping("/{id}/remove")
    public void postRemove(@PathVariable("id") Integer id, Integer userID) {
        Event event = checkEvent(id);
        Optional<User> user = userService.getUser(userID);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "this user does not exist");
        }
        if (event.isHost(user.get().getUserName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "owner can't be removed");
        }
        eventService.removeMember(event, user.get());
    }

    private String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    private Event checkEvent(@PathVariable("id") Integer id) {
        String name = getUsername();
        Optional<Event> eventOptional = eventService.getEvent(id);

        if (eventOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "event does not exist");
        }

        Event event = eventOptional.get();
        if (!event.isHost(name)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return event;
    }
}
