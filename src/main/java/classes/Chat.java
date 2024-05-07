package classes;

import ui.EventChatView;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    //Attributes
    private List<Message> messages = new ArrayList<>();
    private List<EventChatView> UIs = new ArrayList<>();


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
        updateUIs();
    }

    public List<Message> getMessages(){
        return messages;
    }

    /**
     * Adds the supplied UI to the UIs list and appends every message to the UIs chat text area
     * @param UI UI instance to be opened
     */
    public void initializeNewUI(EventChatView UI){
        UIs.add(UI);
        for(Message m:messages){
            UI.addMessage(m);
        }
    }

    /**
     * Adds the lastest message of the messages list to every UI
     */
    private void updateUIs(){
        for(EventChatView ui:UIs){
            ui.addMessage(messages.get(messages.size()-1));
        }
    }
}
