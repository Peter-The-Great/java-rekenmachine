module com.pjotr.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.pjotr.calculator to javafx.fxml;
    exports com.pjotr.calculator;
}