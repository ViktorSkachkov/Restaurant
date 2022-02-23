module com.example.individualproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.individualproject to javafx.fxml;
    exports com.example.individualproject;
}