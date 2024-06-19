module event.planer {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires org.junit.jupiter.api;
    opens ui to javafx.fxml;
    opens classes to javafx.base;
    exports ui;
}