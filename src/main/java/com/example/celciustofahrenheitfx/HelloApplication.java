package com.example.celciustofahrenheitfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox container = new VBox(10);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(15));

        Text title = new Text("C => F Converter");
        // change font size
        title.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        title.setFill(Color.BLUE);
        container.getChildren().add(title);

        // celsius section
        Label celsiusLabel = new Label("Celsius:");
        TextField celsiusTextField = new TextField();
        Button toFahrenheitBtn = new Button("Convert (F)");
        HBox celsiusContainer = new HBox(5, celsiusLabel, celsiusTextField, toFahrenheitBtn);
        celsiusContainer.setHgrow(celsiusTextField, Priority.SOMETIMES);
        celsiusContainer.setAlignment(Pos.CENTER);
        container.getChildren().add(celsiusContainer);

        // fahrenheit section
        Label fahrenheitLabel = new Label("Fahrenheit:");
        TextField fahrenheitTextField = new TextField();
        Button toCelsiusBtn = new Button("Convert (C)");
        HBox fahrenheitContainer = new HBox(5, fahrenheitLabel, fahrenheitTextField, toCelsiusBtn);
        fahrenheitContainer.setHgrow(fahrenheitTextField, Priority.SOMETIMES);
        fahrenheitContainer.setAlignment(Pos.CENTER);
        container.getChildren().add(fahrenheitContainer);

        // init text fields values
        celsiusTextField.setText("0");
        fahrenheitTextField.setText("0");

        // buttons action
        // f -> c
        toCelsiusBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int fValue = Integer.parseInt(fahrenheitTextField.getText());
                int result = (fValue - 32) * 5 / 9;
                celsiusTextField.setText(String.valueOf(result));
            }
        });

        // c -> f
        toFahrenheitBtn.setOnAction(actionEvent -> {
            int cValue = Integer.parseInt(celsiusTextField.getText());
            int result = cValue * 9 / 5 + 32;
            fahrenheitTextField.setText(String.valueOf(result));
        });

        Scene scene = new Scene(container);
        stage.setTitle("Celsius Fahrenheit Converter!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}