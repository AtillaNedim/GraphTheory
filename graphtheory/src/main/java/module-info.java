module code.graphtheory.graphtheory {
    requires javafx.controls;
    requires javafx.fxml;


    opens code.graphtheory.FX to javafx.fxml;
    exports code.graphtheory.FX;
}