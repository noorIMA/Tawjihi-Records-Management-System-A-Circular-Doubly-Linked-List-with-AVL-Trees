module com.example.tawjihi {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tawjihi to javafx.fxml;
    exports com.example.tawjihi;



}