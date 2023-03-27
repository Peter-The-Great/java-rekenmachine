package com.pjotr.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Popup;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static CheckMenuItem select_menu = new CheckMenuItem();
    ArrayList<String> arrayList = new ArrayList<>();
    String expression, number=" ";
    char type = 'D';
    @FXML
    Label answer, history;
    @FXML
    Button sin, tan, cos, fact, pi, ln, Inverse, e, log, equal;
    @FXML
    RadioButton Scientific, Standard, Degree, Radian;
    @FXML
    TextField box;
    int x = 0;
    @FXML
    CheckMenuItem len;
    @FXML
    RadioMenuItem scientific_item,standard_item;
    @FXML
    public void numbers(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (Character.isDigit(button.getText().charAt(0))||button.getText().equals("e")||button.getText().equals("π")) {
            number = number + button.getText();
            box.setText(box.getText() + button.getText());
            arrayList.add(button.getText());
        }
        if (button.getText().equals(".") && !number.contains(".")) {
            number = number + button.getText();
            box.setText(box.getText() + button.getText());
            arrayList.add(button.getText());
        }
        expression = box.getText();
    }
    @FXML
    protected void power(){
        if (!number.equals(" ")){
            box.setText(box.getText()+"^(");
            arrayList.add("^(");
            expression=box.getText();
        }

    }
    @FXML
    protected void Operator(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (!box.getText().equals(""))
        {
            if (!number.equals(" ")) {
                box.setText(expression + button.getText());
                arrayList.add(button.getText());
                x = arrayList.size() - 1;
            }
            else if (!box.getText().equals("-")){
                box.setText(expression + button.getText());
                arrayList.set(x, button.getText());
            }
        }
        if (button.getText().equals("-") && box.getText().equals("")) {
            arrayList.add(button.getText());
            box.setText(box.getText() + button.getText());
            expression = box.getText();
        }
        System.out.println(arrayList);
        number = " ";
    }

    @FXML
    protected void brackets(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        arrayList.add(button.getText());
        box.setText(box.getText() + button.getText());
        expression = box.getText();
        number = " ";
    }

    @FXML
    protected void Evaluate() {
        if (!box.getText().equals("")) {
            try {
                Calculator calculator = new Calculator(box.getText(), type);
                history.setText(calculator.mem + "=");
                answer.setText("" + calculator.findAnswers());
            } catch (Exception e) {
                box.setText("");
                answer.setText("Bad Expression");
            }
        }
    }

    @FXML
    protected void clear() {
        expression = "";
        answer.setText("");
        arrayList.clear();
        history.setText("");
        box.setText(expression);
        number = " ";
    }

    @FXML
    protected void MathFunction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (button.getText().equals("n!")) {
            arrayList.add("!");
            box.setText(box.getText() + "!");
            expression = box.getText();
        }
        if (button.getText().equals("sin")) {
            arrayList.add("sin(");
            box.setText(box.getText() + "sin(");
            expression = box.getText();
        }
        if (button.getText().equals("asin")) {
            arrayList.add("asin(");
            box.setText(box.getText() + "asin(");
            expression = box.getText();
        }
        if (button.getText().equals("cos")) {
            arrayList.add("cos(");
            box.setText(box.getText() + "cos(");
            expression = box.getText();
        }
        if (button.getText().equals("acos")) {
            arrayList.add("acos(");
            box.setText(box.getText() + "acos(");
            expression = box.getText();
        }
        if (button.getText().equals("tan")) {
            arrayList.add("tan(");
            box.setText(box.getText() + "tan(");
            expression = box.getText();
        }
        if (button.getText().equals("atan")) {
            arrayList.add("atan(");
            box.setText(box.getText() + "atan(");
            expression = box.getText();
        }
        if (button.getText().equals("log")) {
            arrayList.add("log(");
            box.setText(box.getText() + "log(");
            expression = box.getText();
        }
        if (button.getText().equals("10^x")) {
            arrayList.add("10^");
            box.setText(box.getText() + "10^");
            expression = box.getText();
        }
        if (button.getText().equals("ln")) {
            arrayList.add("ln(");
            box.setText(box.getText() + "ln(");
            expression = box.getText();
        }
        if (button.getText().equals("e^x")) {
            arrayList.add("e^");
            box.setText(box.getText() + "e^");
            expression = box.getText();
        }
        if (button.getText().equals("√")) {
            arrayList.add("√(");
            box.setText(box.getText() + "√(");
            expression = box.getText();
        }
        number = " ";
    }
    @FXML
    public void rational(){
        if (!answer.getText().isEmpty()){
            Rational rational=new Rational(answer.getText());
            answer.setText(rational.P_by_QForm());
        }
    }
     @FXML
     public void showPopUp(){
         Popup popup=new Popup();
         popup.setOpacity(0.80);
         popup.setX(Main.stage.getX()+70);
         popup.setY(Main.stage.getY()+80);
         popup.getContent().add(Main.pop);
         popup.setAutoHide(true);
         if (!popup.isShowing()){
             popup.show(Main.stage);
         }
     }
    @FXML
    protected void cut() {
        if (arrayList.size() != 0) {
            expression = "";
            arrayList.remove(arrayList.size() - 1);
            for (String s : arrayList) expression = String.format("%s%s", expression, s);
            box.setText(expression);
        }
    }

    @FXML
    protected void InverseFunction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (!button.isDefaultButton()) {
            log.setText("10^x");
            ln.setText("e^x");
            sin.setText("asin");
            cos.setText("acos");
            tan.setText("atan");
            button.setDefaultButton(true);
            button.setStyle("-fx-background-color:#0bade0;-fx-text-fill:white");
        } else {
            button.setDefaultButton(false);
            button.setStyle("-fx-background-color:white");
            log.setText("log");
            ln.setText("ln");
            sin.setText("sin");
            cos.setText("cos");
            tan.setText("tan");
        }
    }

    /**
     * @initializeRadioItems Dit is een methode die de radio items initialiseerd, om zo null errors te voorkomen.
     */
    public void initializeRadioItems(){
        standard_item = new RadioMenuItem("Standard");
        standard_item.setSelected(true);
        scientific_item = new RadioMenuItem("Scientific");
        scientific_item.setSelected(false);
    }
    @FXML
    protected void Enable(ActionEvent actionEvent) {
        number = " ";
        initializeRadioItems();
        if (((RadioButton) actionEvent.getSource()).getText().equals("Scientific")) {
            Standard.setSelected(false);
            scientific_item.setSelected(true);
            standard_item.setSelected(false);
            Select();
        }
        if (((RadioButton) actionEvent.getSource()).getText().equals("Standard")) {
            Scientific.setSelected(false);
            standard_item.setSelected(true);
            scientific_item.setSelected(false);
            DeSelect();
        }

    }
    void Select(){
        sin.setDisable(false);
        cos.setDisable(false);
        tan.setDisable(false);
        fact.setDisable(false);
        pi.setDisable(false);
        ln.setDisable(false);
        log.setDisable(false);
        Inverse.setDisable(false);
        e.setDisable(false);
    }
    void DeSelect(){
        sin.setDisable(true);
        cos.setDisable(true);
        tan.setDisable(true);
        fact.setDisable(true);
        pi.setDisable(true);
        ln.setDisable(true);
        log.setDisable(true);
        Inverse.setDisable(true);
        e.setDisable(true);
    }
    @FXML
    protected void measureSystem(ActionEvent actionEvent) {
        if (((RadioButton) actionEvent.getSource()).getText().equals("Degree")) {
            Radian.setSelected(false);
            type = 'D';
        }
        if (((RadioButton) actionEvent.getSource()).getText().equals("Radian")) {
            type = 'R';
            Degree.setSelected(false);
        }
    }

    @FXML
    protected void Menu_items(ActionEvent actionEvent) {
        RadioMenuItem radioMenuItem = (RadioMenuItem) actionEvent.getSource();
        if (radioMenuItem.getText().equals("Conversion")) {
            if(radioMenuItem.isSelected())
            Main.stage.setWidth(985 + 65);
            else Main.stage.setWidth(545 + 15);
        }
        if (radioMenuItem.getText().equals("Scientific"))
        {
            if(radioMenuItem.isSelected())
            {
                standard_item.setSelected(false);
                Standard.setSelected(false);
                Scientific.setSelected(true);
                Select();
            }
            else {
                standard_item.setSelected(true);
                Standard.setSelected(true);
                Scientific.setSelected(false);
                DeSelect();
            }
        }
        if (radioMenuItem.getText().equals("Standard")){
            if(radioMenuItem.isSelected())
            {
                Scientific.setSelected(false);
                Standard.setSelected(true);
                scientific_item.setSelected(false);
                DeSelect();
            }
            else {
                scientific_item.setSelected(true);
                Standard.setSelected(false);
                Scientific.setSelected(true);
                Select();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select_menu = len;
    }
}
