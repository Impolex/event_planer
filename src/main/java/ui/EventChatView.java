package ui;

import classes.Chat;
import classes.Message;
import classes.User;
import interfaces.UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EventChatView implements UI, ActionListener {
    //Attributes
    private Chat chat;
    private User user;
    private BufferedImage myPicture;
    private JFrame frame;
    private JPanel userPanel;
    private JPanel centerPanel;
    private JPanel buttonPanel;
    private JLabel userLabel;
    private JLabel picLabel;
    private JPanel bottomPanel;
    private JButton sendMessageButton;
    private JButton closeChatButton;
    private JTextArea chatArea;
    private JScrollPane chatScrollPane;
    private JTextField messageField;

    //Constructor
    public EventChatView(String windowTitle, User user, Chat chat){
        this.chat = chat;
        this.user = user;
        setImage();
        initUI(windowTitle);
        chat.initializeNewUI(this);
    }

    //Methods

    /**
     * Adds a string of the supplied message object to the chat TextArea, making the message and it's user appear on it
     * @param message
     */
    public void addMessage(Message message){
        this.chatArea.append(message.toString());
    }

    public void setImage(){
        try {
            myPicture = ImageIO.read(new File("documentation/logo/letsevent_transparent.png"));
            picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public void closeUI(){
        frame.dispose();
    }

    @Override
    public void initUI(String windowTitle) {
        //Frame
        frame = new JFrame(windowTitle);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(picLabel, BorderLayout.NORTH);

        //Username
        userLabel = new JLabel(user.getUserName());
        userPanel = new JPanel();
        userPanel.add(userLabel);
        userPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        frame.add(userPanel, BorderLayout.WEST);

        //Chat window elements
        chatArea = new JTextArea();
        chatArea.setEnabled(false);
        chatScrollPane = new JScrollPane(chatArea);
        //chatScrollPane.add(chatArea);
        messageField = new JTextField();
        buttonPanel = new JPanel();
        bottomPanel = new JPanel(new BorderLayout());

        //Event Actionbuttons
        sendMessageButton = new JButton("Send message");
        closeChatButton = new JButton("Close chat");
        sendMessageButton.addActionListener(this);
        closeChatButton.addActionListener(this);
        buttonPanel.add(sendMessageButton);
        buttonPanel.add(closeChatButton);
        bottomPanel.add(messageField, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        //Center panel
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(chatScrollPane, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        //Finalizing frame
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==closeChatButton){
            closeUI();
            }

        else{
            if(messageField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter a message");
            }
            else{
                chat.sendMessage(user, messageField.getText());
                messageField.setText("");
            }
        }
    }
}
