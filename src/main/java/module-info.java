module org.example.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    exports app;
    opens app to javafx.fxml;

    exports pojo;
    opens pojo to com.fasterxml.jackson.databind;
}