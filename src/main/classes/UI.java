package src.main.classes;

import javax.swing.*;

public class UI {
    //Attributes
    private JFrame frame;

    //Constructor
    public UI(){
        initUI();

    }

    //Methods
    private void initUI(){
        frame = new JFrame("LetsEvent");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
