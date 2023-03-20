package com.pjotr.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Objects;

public class Calculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        /*
          Deze code zorgt ervoor dat de achtergrond van de stage transparant is.
          Dit is nodig om de achtergrond van de stage te kunnen veranderen.
          De achtergrond van de stage wordt veranderd in de CSS.
          De CSS wordt geladen in de FXML file.
          We pakken daarna ook de logo.png uit de resources map.
          Dit is de icon die in de taskbar van Windows te zien is.
         */
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Rekenmachine");

        //Hier wordt de icon geladen.
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/logo.png"))));

        //Hier wordt de controller geinitialiseerd.
        ((CalculatorController)fxmlLoader.getController()).init(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}