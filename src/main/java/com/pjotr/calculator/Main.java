package com.pjotr.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    // Hier worden de variabelen gedeclareerd.
    // Deze variabelen zijn static, zodat ze in andere klassen kunnen worden aangeroepen.

    /** @stage De eerste is een stage, deze wordt gebruikt om de applicatie te tonen. */
    static Stage stage;

    /** @parent Dit is een AnchorPane, dit is een paneel waarin de belangrijke elementen kunnen worden geplaatst. */
    /** @pop Dit is een AnchorPane, dit is een paneel waarin een informatie panneel geplaats wordt. */
    static AnchorPane parent, pop;

    //Dit is een scene, deze wordt gebruikt om de AnchorPane te tonen.
    static Scene scene;

    /**
     * @start
     * @param primaryStage
     * Deze methode start de javaFX library en laad de twee fxml bestanden in. Als er een fout optreedt, wordt deze afgevangen via een exception.
     */

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pop = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("PopUpPane.fxml")));
        parent = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("calculator_layout.fxml")));
        scene = new Scene(parent);
        stage = primaryStage;
        primaryStage.setScene(scene);
        primaryStage.setOpacity(0.95);
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().addAll(new Image(Objects.requireNonNull(Main.class.getResource("images/icon.png")).toString()));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @main
     * @param args
     * Deze methode start de applicatie.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
