package src.main.interfaces;

public interface UI {
    /**
     * Initializes the UI components of the specific view
     * @param windowTitle
     */
    void initUI(String windowTitle);

    /**
     * Reads the event title, sets it as the labels new text and repaints the label
     */
    void repaintTitleLabel();

    /**
     * Reads the event description, sets it as the labels new text and repaints the label
     */
    void repaintDescriptionLabel();

    /**
     * Reads the event date, sets it as the labels new text and repaints the label
     */
    void repaintDateLabel();

    /**
     * Reads the event place, sets it as the labels new text and repaints the label
     */
    void repaintPlaceLabel();

    /**
     * Closes the frame of the UI object
     */
    void closeUI();

    /**
     * Reads the image to be displayed on the top of the UI and sets it as a local variable
     */
    void setImage();

}
