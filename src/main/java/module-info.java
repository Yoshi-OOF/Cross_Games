module org.example.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    exports app;
    opens app to javafx.fxml;
}