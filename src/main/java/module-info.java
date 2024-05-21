module org.example.main {
    requires javafx.controls;
    requires javafx.fxml;

    exports app;
    opens app to javafx.fxml;
}