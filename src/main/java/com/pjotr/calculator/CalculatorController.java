package com.pjotr.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CalculatorController {

    //Hier worden de labels, knoppen en de titelbalk gedefinieerd.
    @FXML private Pane titlePane;
    @FXML private ImageView btnMinimize, btnClose;
    @FXML private Label lblResult;

    //Hier woorden de waardes van x en y opgeslagen.
    private double x, y;

    // Eerste nummer is altijd 0.
    private double num1 = 0;

    //Maak alvast een operator voor default.
    private String operator = "+";

    /**
     * @init
     * Bij deze functie wordt de stage meegegeven.
     * Daarna wordt er gekeken of de muis op de titel is.
     * Als dit zo is wordt de waarde van x en y gelijk gesteld aan de waarde van de muis.
     * Als dit niet zo is wordt de waarde van x en y gelijk gesteld aan de waarde van de muis.
     */
    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }
    
    public void handleKeyEvent(KeyCode code) {
        switch (code) {
            case DIGIT0:
            case NUMPAD0:
                // Handle 0 key press
                break;
            case DIGIT1:
            case NUMPAD1:
                // Handle 1 key press
                break;
            // Add more cases for other keys
            default:
                break;
        }
    }

    /**
     * @kliknummer
     * Bij deze functie wordt de waarde van de knop omgezet naar een int.
     * Daarna wordt er gekeken of de waarde van lblResult gelijk is aan 0.
     * Als dit zo is wordt de waarde van lblResult gelijk gesteld aan de waarde van de knop.
     * Als dit niet zo is wordt de waarde van lblResult gelijk gesteld aan de waarde van lblResult * 10 + de waarde van de knop.
     */
    @FXML
    void kliknummer(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("btn",""));
        lblResult.setText(Double.parseDouble(lblResult.getText())==0 ? String.valueOf((double)value) : String.valueOf(Double.parseDouble(lblResult.getText()) * 10 + value));
    }

    /**
     * @kliksymbol
     * Bij deze functie wordt de waarde van de knop omgezet naar een String.
     * Daarna wordt er gekeken of de waarde van de knop gelijk is aan "Equals".
     * Als dit zo is wordt er gekeken welke operator er is gebruikt.
     * Daarna wordt er gekeken welke operator er is gebruikt en wordt er gekeken wat de waarde van lblResult is.
     * Als dit zo is wordt de waarde van lblResult gelijk gesteld aan de waarde van num1 + de waarde van lblResult.
     * Als dit niet zo is wordt de waarde van lblResult gelijk gesteld aan de waarde van num1 - de waarde van lblResult.
     */
    @FXML
    void kliksymbol(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        if(symbol.equals("Equals")) {
            // Doe hem in double want dat is wat makkelijker dan met een int te werken.
            double num2 = Double.parseDouble(lblResult.getText());
            // Hier moet de operator uit de switch komen. en daarna de som worden berekend.
            switch (operator) {
                case "+" -> lblResult.setText((num1+num2) + "");
                case "-" -> lblResult.setText((num1-num2) + "");
                case "*" -> lblResult.setText((num1*num2) + "");
                case "/" -> lblResult.setText((num1/num2) + "");
            }
            operator = ".";
        }
        //Als je op clear klikt moet de waarde van lblResult gelijk worden gesteld aan 0.0.
        else if(symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
        }
        else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
            }
            num1 = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0.0));
        }
    }
}