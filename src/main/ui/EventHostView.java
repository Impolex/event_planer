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

    //Demonstration
    int userCount = 2;

    //Constructor
    public EventHostView(String windowTitle, Event event, User user){
        this.user = user;
        this.event = event;
        setImage();
        initUI(windowTitle);
    }

    //Methods

    public void repaintTitleLabel(){
        titleLabel.setText("Title: "+event.getTitle());
        this.titleLabel.repaint();
    }

    public void repaintDescriptionLabel(){
        descriptionLabel.setText("Description: "+event.getDescription());
        this.descriptionLabel.repaint();
    }

    public void repaintDateLabel(){
        this.dateLabel.setText("Date: "+event.getDate());
        this.dateLabel.repaint();
    }

    public void repaintPlaceLabel(){
        this.placeLabel.setText("Place: "+event.getPlace());
        this.placeLabel.repaint();
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

    /**
     * Opens a new window showing a list of buttons. Each button represents a participator of the event.
     * On click, the method returns the selected participator
     * @return
     */
    private User selectParticipatorUI(){
        //Getting all users and saving the usernames in a list
        List<String> participants = new ArrayList<String>();
        for (User user:event.getParticipants()){
            participants.add(user.getUserName());
        }

        //A custom option pane which displays a button for each user.
        //On click the option pane disappears and returns an integer which corresponds to the selected user
        int option = JOptionPane.showOptionDialog(null, "Select user",
                ("Participants of \""+event.getTitle()+"\""), JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, participants.toArray(), participants.toArray()[0]);
        return event.getParticipants().get(option);
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
        addParticipatorButton.addActionListener(this);
        removeParticipatorButton.addActionListener(this);

        buttonPanel.add(editTitleButton);
        buttonPanel.add(editDescriptionButton);
        buttonPanel.add(editPlaceButton);
        buttonPanel.add(editDateButton);
        buttonPanel.add(cancelEventButton);
        buttonPanel.add(addParticipatorButton);
        buttonPanel.add(removeParticipatorButton);
        //buttonPanel.add(elevateParticipatorButton);
        //buttonPanel.add(demoteOrganiserButton);
        //buttonPanel.add(makeHostButton);



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
            event.setTitle(JOptionPane.showInputDialog("Insert the new event title"));
            for(UI ui:event.getUIs()){
                ui.repaintTitleLabel();
            }
        }
        else if(e.getSource()==editDescriptionButton){
            event.setDescription(JOptionPane.showInputDialog("Insert the new event description"));
            for(UI ui:event.getUIs()){
                ui.repaintDescriptionLabel();
            }
        }
        else if(e.getSource()==editPlaceButton){
            event.setPlace(JOptionPane.showInputDialog("Insert the new event place"));
            for(UI ui:event.getUIs()){
                ui.repaintPlaceLabel();
            }
        }
        else if(e.getSource()==editDateButton){
            event.setDate(JOptionPane.showInputDialog("Insert the new event date"));
            for(UI ui:event.getUIs()){
                ui.repaintDateLabel();
            }
        }
        else if(e.getSource()==cancelEventButton){
            System.exit(0);

        }
        else if (e.getSource()==addParticipatorButton) {
            User user = new User();
            user.setUserId(userCount);
            user.setUserName("user"+userCount);
            event.addParticipator(user);
            userCount++;
        }
        else if (e.getSource()==removeParticipatorButton) {
            //Uses the Value returned from the option pane to get the specified user from the event.
            //Unless the user ist the host, the selected user is removed.
            User selUser = selectParticipatorUI();
            if (selUser == event.getHost()){
                JOptionPane.showMessageDialog(null, "The host cannot be removed from the event",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                event.removeParticipator(selUser);
            }
        }
        else if (e.getSource()==elevateParticipatorButton) {

        }
        else if (e.getSource()==demoteOrganiserButton){

        }
        else if (e.getSource()==makeHostButton) {

        }
    }
}
