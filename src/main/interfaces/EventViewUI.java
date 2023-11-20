package src.main.interfaces;

public interface EventViewUI extends UI{
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
     * Opens the chat UI for this event
     */
    void openChat();
}
