module event.planer {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    opens ui to javafx.fxml;
    opens classes to javafx.base;
    exports ui;
}