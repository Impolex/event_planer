package src.main.classes;

public class Message {
    //Attributes
    private User sender;
    private String messageText;

    //Constructor
    public Message(User sender, String messageText){
        this.sender = sender;
        this.messageText = messageText;
    }

    //Methods

    @Override
    public String toString() {
        return sender.getUserName()+": "+messageText+System.lineSeparator();
    }
}
