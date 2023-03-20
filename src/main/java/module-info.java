module com.pjotr.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pjotr.calculator to javafx.fxml;
    exports com.pjotr.calculator;
}