module com.enricledo.mp3_project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.enricledo.mp3_project to javafx.fxml;
    exports com.enricledo.mp3_project;
}
