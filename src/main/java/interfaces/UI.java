package interfaces;

public interface UI {
    /**
     * Initializes the UI components of the specific view
     * @param windowTitle Title to be given to the window
     */
    void initUI(String windowTitle);

    /**
     * Closes the frame of the UI object
     */
    void closeUI();

    /**
     * Reads the image to be displayed on the top of the UI and sets it as a local variable
     */
    void setImage();

}
