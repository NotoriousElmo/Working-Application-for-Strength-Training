package com.example.demo;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProgramRunner extends Application {
    private Integer currentSession = 0;
    private TextFlow sessionTextFlow;
    private ProgramCreator programCreator;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2023-03-27", formatter);
        programCreator = new ProgramCreator(
                205, 180, 107.5f,
                "Barbell Row", "Military Press",
                "Lat Pulldown", date);

        sessionTextFlow = createSessionTextFlow(programCreator.program.get(currentSession));
        sessionTextFlow.setTextAlignment(TextAlignment.CENTER);

        Button nextButton = new Button("Next");
        nextButton.setOnAction(e -> nextSession());

        Button previousButton = new Button("Previous");
        previousButton.setOnAction(e -> previousSession());

        VBox sessionBox = new VBox(20);
        sessionBox.setAlignment(Pos.CENTER);
        sessionBox.getChildren().add(sessionTextFlow);

        HBox buttonsBox = new HBox(20);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(previousButton, nextButton);

        BorderPane root = new BorderPane();
        root.setCenter(sessionBox);
        root.setBottom(buttonsBox);
        BorderPane.setMargin(sessionBox, new Insets(50, 0, 0, 0));
        BorderPane.setMargin(buttonsBox, new Insets(0, 0, 50, 0));

        // Set the background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Training Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void nextSession() {
        if (currentSession < programCreator.program.size() - 1) {
            currentSession++;
            sessionTextFlow.getChildren().clear();
            sessionTextFlow.getChildren().add(createSessionText(programCreator.program.get(currentSession)));
        }
    }

    public void previousSession() {
        if (currentSession > 0) {
            currentSession--;
            sessionTextFlow.getChildren().clear();
            sessionTextFlow.getChildren().add(createSessionText(programCreator.program.get(currentSession)));
        }
    }

    private TextFlow createSessionTextFlow(String sessionText) {
        TextFlow textFlow = new TextFlow();
        textFlow.setTextAlignment(TextAlignment.CENTER);

        String[] lines = sessionText.split("\n");
        for (String line : lines) {
            Text text = createSessionText(line);
            textFlow.getChildren().add(text);
        }

        textFlow.setLineSpacing(10); // Adjust the line spacing here

        return textFlow;
    }

    private Text createSessionText(String text) {
        Text sessionText = new Text(text + "\n");
        sessionText.setFont(Font.font("Courier New", 20)); // Use a monospaced font
        sessionText.setFill(Color.WHITE);
        return sessionText;
    }
}
