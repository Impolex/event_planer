module event.planer {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    opens ui to javafx.fxml;
    exports ui;
}