package com.example.letseventdemo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

public class Chat {//Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private List<Message> messages = new ArrayList<>();
    //private List<EventChatView> UIs = new ArrayList<>();


    //Constructor
    public Chat(){

    }

    //Methods

    /**
     * Adds a new message object, consisting of the supplied user and message text, to the messages list.
     * Also calls updateUI()
     * @param user The user instance sending the message
     * @param messageText The contents of the message
     */
    public void sendMessage(User user, String messageText){
        messages.add(new Message(user, messageText));
        //updateUIs();
    }

    public List<Message> getMessages(){
        return messages;
    }

}
