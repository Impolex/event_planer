package src.main.ui;

import src.main.classes.User;
import src.main.interfaces.UI;
import src.main.classes.Event;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventHostView implements UI, ActionListener {
    //Attributes
    private User user;
    private Event event;
    private BufferedImage myPicture;
    private JFrame frame;
    private JPanel userPanel;
    private JPanel centerPanel;
    private JPanel titlePanel;
    private JPanel descriptionPanel;
    private JPanel datePanel;
    private JPanel placePanel;
    private JPanel hostPanel;
    private JPanel buttonPanel;
    private JLabel userLabel;
    private JLabel picLabel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel dateLabel;
    private JLabel placeLabel;
    private JLabel hostLabel;
    private JButton editTitleButton;
    private JButton editDescriptionButton;
    private JButton editPlaceButton;
    private JButton editDateButton;
    private JButton cancelEventButton;
    private JButton addParticipatorButton;
    private JButton removeParticipatorButton;
    private JButton elevateParticipatorButton;
    private JButton demoteOrganiserButton;
    private JButton makeHostButton;

    //Constructor
    public EventHostView(String windowTitle, Event event, User user){
        this.user = user;
        this.event = event;
        setImage();
        initUI(windowTitle);
    }

    //Methods

    /**
     * Reads the image to be displayed on the top of the UI and sets it as a local variable
     */
    private void setImage(){
        try {
            myPicture = ImageIO.read(new File("documentation/logo/letsevent_transparent.png"));
            picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    private User selectParticipatorUI(){
        List<JButton> participants = new ArrayList<>();
        for (User user:event.getParticipants()){
            participants.add(new JButton(user.getUserName()));
        }

        return null;
    }

    @Override
    public void initUI(String windowTitle) {
        //Frame
        frame = new JFrame(windowTitle);
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(picLabel, BorderLayout.NORTH);

        //Username
        userLabel = new JLabel(user.getUserName());
        userPanel = new JPanel();
        userPanel.add(userLabel);
        userPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        frame.add(userPanel, BorderLayout.WEST);

        //Event data
        titleLabel = new JLabel("Title: "+event.getTitle());
        descriptionLabel = new JLabel("Description: "+event.getDescription());
        placeLabel = new JLabel("Place: "+event.getPlace());
        dateLabel = new JLabel("Date: "+event.getDate());
        hostLabel = new JLabel("Host: "+event.getHost().getUserName());

        titlePanel = new JPanel();
        descriptionPanel = new JPanel();
        placePanel = new JPanel();
        datePanel = new JPanel();
        hostPanel = new JPanel();
        buttonPanel = new JPanel();

        titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        placePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        hostPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        titlePanel.add(titleLabel);
        descriptionPanel.add(descriptionLabel);
        placePanel.add(placeLabel);
        datePanel.add(dateLabel);
        hostPanel.add(hostLabel);

        //Event Actionbuttons
        editTitleButton = new JButton("Edit title");
        editDescriptionButton = new JButton("Edit description");
        editPlaceButton = new JButton("Edit place");
        editDateButton = new JButton("Edit date");
        cancelEventButton = new JButton("Cancel event");
        addParticipatorButton = new JButton("Add participator");
        removeParticipatorButton = new JButton("Remove participator");
        elevateParticipatorButton = new JButton("Elevate participator");
        demoteOrganiserButton = new JButton("Demote organiser");
        makeHostButton = new JButton("Change host");

        editTitleButton.addActionListener(this);
        editDescriptionButton.addActionListener(this);
        editPlaceButton.addActionListener(this);
        editDateButton.addActionListener(this);
        cancelEventButton.addActionListener(this);

        buttonPanel.add(editTitleButton);
        buttonPanel.add(editDescriptionButton);
        buttonPanel.add(editPlaceButton);
        buttonPanel.add(editDateButton);
        buttonPanel.add(cancelEventButton);
        buttonPanel.add(addParticipatorButton);
        buttonPanel.add(removeParticipatorButton);
        buttonPanel.add(elevateParticipatorButton);
        buttonPanel.add(demoteOrganiserButton);
        buttonPanel.add(makeHostButton);



        //Center panel
        centerPanel = new JPanel(new GridLayout(6, 1));

        centerPanel.add(titlePanel);
        centerPanel.add(descriptionPanel);
        centerPanel.add(placePanel);
        centerPanel.add(datePanel);
        centerPanel.add(hostPanel);
        centerPanel.add(buttonPanel);

        //Finalizing frame
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==editTitleButton){

        }
        else if(e.getSource()==editDescriptionButton){

        }
        else if(e.getSource()==editPlaceButton){

        }
        else if(e.getSource()==editDateButton){

        }
        else if(e.getSource()==cancelEventButton){

        }
    }
}
