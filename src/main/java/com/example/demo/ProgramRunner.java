package com.example.demo;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class ProgramRunner extends Application {

    private float newSquat;
    private float newBench;
    private float newDL;
    private String newUpperFirst;
    private String newShoulder;
    private String newUpperSecond;
    private LocalDate newDate;
    private int currentSession;
    private ProgramCreator programCreator;

    @Override
    public void stop() {
        saveProgramCreator();
    }

    private void saveProgramCreator() {
        try (FileOutputStream fileOut = new FileOutputStream("programCreator.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            programCreator.currentSession = currentSession;

            objectOut.writeObject(programCreator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ProgramCreator loadProgramCreator() {
        programCreator = null;
        try (FileInputStream fileIn = new FileInputStream("programCreator.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            return (ProgramCreator) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return programCreator;
    }

    @Override
    public void start(Stage primaryStage) {
        programCreator = loadProgramCreator();
        if (programCreator == null) {
            startScreen(primaryStage);
        } else {
            currentSession = programCreator.currentSession;
            if (currentSession > programCreator.program.size() - 1) {
                currentSession = programCreator.program.size() - 1;
            }
            showSession(primaryStage);
        }
    }

    private void startScreen(Stage stage) {
        currentSession = 0;
        Text textFirst = new Text("Squat Max: ");
        Text textSecond = new Text("Bench Press Max: ");
        Text textThird = new Text("Deadlift Max: ");
        Text textFourth = new Text("Shoulder Accessory: ");
        Text textFifth = new Text("First Back Accessory: ");
        Text textSixth = new Text("Second Back Accessory: ");
        Text textSeventh = new Text("Start Date: ");


        TextField textFieldSquat = new TextField();
        TextField textFieldBench = new TextField();
        TextField textFieldDL = new TextField();

        ChoiceBox<String> choiceBoxShoulder = new ChoiceBox<>();
        choiceBoxShoulder.getItems().addAll("Standing OHP", "Sitting OHP", "Dumbbell OHP");
        ChoiceBox<String> choiceBoxUpperFirst = new ChoiceBox<>();
        choiceBoxUpperFirst.getItems().addAll("Barbell Row", "Machine Row", "Dumbbell Row");
        ChoiceBox<String> choiceBoxUpperSecond = new ChoiceBox<>();
        choiceBoxUpperSecond.getItems().addAll("Lat Pulldown", "Pull-Up", "Chin-Up");

        DatePicker datePicker = new DatePicker();

        Button start = new Button("Start");

        textFirst.setStyle("-fx-font: normal bold 35px 'plain'");
        textSecond.setStyle("-fx-font: normal bold 35px 'plain'");
        textThird.setStyle("-fx-font: normal bold 35px 'plain'");
        textFourth.setStyle("-fx-font: normal bold 35px 'plain'");
        textFifth.setStyle("-fx-font: normal bold 35px 'plain'");
        textSixth.setStyle("-fx-font: normal bold 35px 'plain'");
        textSeventh.setStyle("-fx-font: normal bold 35px 'plain'");
        datePicker.setStyle("-fx-font: normal bold 35px 'plain'");
        start.setStyle("-fx-font: normal bold 35px 'plain'");

        textFirst.setFill(Color.WHITE);
        textSecond.setFill(Color.WHITE);
        textThird.setFill(Color.WHITE);
        textFourth.setFill(Color.WHITE);
        textFifth.setFill(Color.WHITE);
        textSixth.setFill(Color.WHITE);
        textSeventh.setFill(Color.WHITE);
        datePicker.setStyle("-fx-text-fill: white;");

        start.setMinSize(100, 50);
        start.setOnAction(actionEvent -> {
            programCreator = new ProgramCreator(Float.parseFloat(textFieldSquat.getText()),
                    Float.parseFloat(textFieldDL.getText()),
                    Float.parseFloat(textFieldBench.getText()),
                    choiceBoxUpperFirst.getValue(), choiceBoxShoulder.getValue(), choiceBoxUpperSecond.getValue(),
                    datePicker.getValue());
            showSession(stage);
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1080, 2400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");

        gridPane.add(textFirst, 0, 0);
        gridPane.add(textFieldSquat, 1, 0);
        gridPane.add(textSecond, 0, 1);
        gridPane.add(textFieldBench, 1, 1);
        gridPane.add(textThird, 0, 2);
        gridPane.add(textFieldDL, 1, 2);
        gridPane.add(textFourth, 0, 3);
        gridPane.add(choiceBoxShoulder, 1, 3);
        gridPane.add(textFifth, 0, 4);
        gridPane.add(choiceBoxUpperFirst,1,4);
        gridPane.add(textSixth,0,5);
        gridPane.add(choiceBoxUpperSecond,1,5);
        gridPane.add(textSeventh, 0,6);
        gridPane.add(datePicker,1,6);
        gridPane.add(start, 1, 10);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void previousSession(Stage stage) {
        if (currentSession > 0) {
            currentSession--;
            showSession(stage);
        }
    }

    private void nextSession(Stage stage) {
        currentSession++;
        if (currentSession == programCreator.program.size()) {
            restartScreen(stage);
        } else {
            showSession(stage);
        }
    }

    private void restartScreen(Stage stage) {
        Text textFirst = new Text("Would you want to enter new max manually?");
        textFirst.setStyle("-fx-font: normal bold 20px 'Courier New'");
        textFirst.setFill(Color.WHITE);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Yes", "No");

        Button button = new Button("Next");
        button.setMinSize(100, 50);
        button.setOnAction(actionEvent -> {
            if (choiceBox.getValue().equals("Yes")) {
                enterNewMax(stage);
            } else {
                calculateNewMax(stage);
            }
        });
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setMinSize(1080, 2400);
        gridPane.add(textFirst, 0, 0);
        gridPane.add(choiceBox,0, 1);
        gridPane.add(button, 1, 1);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void enterNewMax(Stage stage) {
        Text textFirst = new Text("Squat Max: ");
        Text textSecond = new Text("Bench Press Max: ");
        Text textThird = new Text("Deadlift Max: ");
        Text textFourth = new Text("Do you want to change any accessory exercises?");

        TextField textFieldSquat = new TextField();
        TextField textFieldBench = new TextField();
        TextField textFieldDL = new TextField();

        Button next = new Button("Next");
        next.setStyle("-fx-font: normal bold 35px 'plain'");

        textFirst.setStyle("-fx-font: normal bold 35px 'plain'");
        textSecond.setStyle("-fx-font: normal bold 35px 'plain'");
        textThird.setStyle("-fx-font: normal bold 35px 'plain'");
        textFourth.setStyle("-fx-font: normal bold 35px 'plain'");

        textFirst.setFill(Color.WHITE);
        textSecond.setFill(Color.WHITE);
        textThird.setFill(Color.WHITE);
        textFourth.setFill(Color.WHITE);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Yes", "No");

        next.setMinSize(100, 50);
        next.setOnAction(actionEvent -> {
            newSquat = Float.parseFloat(textFieldSquat.getText());
            newBench = Float.parseFloat(textFieldBench.getText());
            newDL = Float.parseFloat(textFieldDL.getText());
            if (choiceBox.getValue().equals("Yes")) {
                changeAccessories(stage);
            } else {
                newUpperFirst = programCreator.upperBackFirst;
                newShoulder = programCreator.shoulder;
                newUpperSecond = programCreator.upperBackSecond;
                setDate(stage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1080, 2400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");

        gridPane.add(textFirst, 0, 0);
        gridPane.add(textFieldSquat, 1, 0);
        gridPane.add(textSecond, 0, 1);
        gridPane.add(textFieldBench, 1, 1);
        gridPane.add(textThird, 0, 2);
        gridPane.add(textFieldDL, 1, 2);
        gridPane.add(textFourth, 0, 3);
        gridPane.add(choiceBox, 1, 3);
        gridPane.add(next, 1, 10);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void calculateNewMax(Stage stage) {
        Text textFirst = new Text("Squat Reps: ");
        Text textSecond = new Text("Bench Press Reps: ");
        Text textThird = new Text("Deadlift Reps: ");
        Text textFourth = new Text("Do you want to change any accessory exercises?");

        TextField textFieldSquat = new TextField();
        TextField textFieldBench = new TextField();
        TextField textFieldDL = new TextField();

        Button next = new Button("Next");
        next.setStyle("-fx-font: normal bold 35px 'plain'");

        textFirst.setStyle("-fx-font: normal bold 35px 'plain'");
        textSecond.setStyle("-fx-font: normal bold 35px 'plain'");
        textThird.setStyle("-fx-font: normal bold 35px 'plain'");
        textFourth.setStyle("-fx-font: normal bold 35px 'plain'");

        textFirst.setFill(Color.WHITE);
        textSecond.setFill(Color.WHITE);
        textThird.setFill(Color.WHITE);
        textFourth.setFill(Color.WHITE);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Yes", "No");

        next.setMinSize(100, 50);
        next.setOnAction(actionEvent -> {
            calculateMaxes(Integer.valueOf(textFieldSquat.getText()),
                    Integer.valueOf(textFieldBench.getText()),
                    Integer.valueOf(textFieldDL.getText()));
            if (choiceBox.getValue().equals("Yes")) {
                changeAccessories(stage);
            } else {
                newUpperFirst = programCreator.upperBackFirst;
                newShoulder = programCreator.shoulder;
                newUpperSecond = programCreator.upperBackSecond;
                setDate(stage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1080, 2400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");

        gridPane.add(textFirst, 0, 0);
        gridPane.add(textFieldSquat, 1, 0);
        gridPane.add(textSecond, 0, 1);
        gridPane.add(textFieldBench, 1, 1);
        gridPane.add(textThird, 0, 2);
        gridPane.add(textFieldDL, 1, 2);
        gridPane.add(textFourth, 0, 3);
        gridPane.add(choiceBox, 1, 3);
        gridPane.add(next, 1, 10);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void changeAccessories(Stage stage) {
        Text textFourth = new Text("Shoulder Accessory: ");
        Text textFifth = new Text("First Back Accessory: ");
        Text textSixth = new Text("Second Back Accessory: ");

        ChoiceBox<String> choiceBoxShoulder = new ChoiceBox<>();
        choiceBoxShoulder.getItems().addAll("Standing OHP", "Sitting OHP", "Dumbbell OHP");
        ChoiceBox<String> choiceBoxUpperFirst = new ChoiceBox<>();
        choiceBoxUpperFirst.getItems().addAll("Barbell Row", "Machine Row", "Dumbbell Row");
        ChoiceBox<String> choiceBoxUpperSecond = new ChoiceBox<>();
        choiceBoxUpperSecond.getItems().addAll("Lat Pulldown", "Pull-Up", "Chin-Up");

        Button next = new Button("Next");

        textFourth.setStyle("-fx-font: normal bold 35px 'plain'");
        textFifth.setStyle("-fx-font: normal bold 35px 'plain'");
        textSixth.setStyle("-fx-font: normal bold 35px 'plain'");
        next.setStyle("-fx-font: normal bold 35px 'plain'");

        textFourth.setFill(Color.WHITE);
        textFifth.setFill(Color.WHITE);
        textSixth.setFill(Color.WHITE);

        next.setMinSize(100, 50);
        next.setOnAction(actionEvent -> {
            newUpperFirst = choiceBoxUpperFirst.getValue();
            newShoulder = choiceBoxShoulder.getValue();
            newUpperSecond = choiceBoxUpperSecond.getValue();
            setDate(stage);
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1080, 2400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");

        gridPane.add(textFourth, 0, 1);
        gridPane.add(choiceBoxShoulder, 1, 1);
        gridPane.add(textFifth, 0, 2);
        gridPane.add(choiceBoxUpperFirst,1,2);
        gridPane.add(textSixth,0,3);
        gridPane.add(choiceBoxUpperSecond,1,3);
        gridPane.add(next, 1, 4);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void setDate(Stage stage) {
        Text textSeventh = new Text("Start Date: ");

        DatePicker datePicker = new DatePicker();

        Button start = new Button("Start");

        textSeventh.setStyle("-fx-font: normal bold 35px 'plain'");
        datePicker.setStyle("-fx-font: normal bold 35px 'plain'");
        start.setStyle("-fx-font: normal bold 35px 'plain'");

        textSeventh.setFill(Color.WHITE);
        datePicker.setStyle("-fx-text-fill: white;");

        start.setMinSize(100, 50);
        start.setOnAction(actionEvent -> {
            newDate = datePicker.getValue();
            programCreator = new ProgramCreator(newSquat, newDL, newBench
                    , newUpperFirst, newShoulder, newUpperSecond, newDate);
            currentSession = 0;
            showSession(stage);
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1080, 2400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");

        gridPane.add(textSeventh, 0,1);
        gridPane.add(datePicker,1,2);
        gridPane.add(start, 1, 3);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private void calculateMaxes(Integer squatReps, Integer benchReps, Integer deadliftReps) {
        newSquat = getMax(programCreator.squatMax, squatReps);
        newBench = getMax(programCreator.benchMax, benchReps);
        newDL = getMax(programCreator.deadLiftMax, deadliftReps);
    }

    private float getMax(float max, Integer reps) {
        if (reps == 0) {
            return programCreator.mRound(max / 1.025, 2.5).floatValue();
        } else if (reps == 2) {
            return programCreator.mRound(max * 1.03, 2.5).floatValue();
        } else if (reps == 3) {
            return programCreator.mRound(max * 1.06, 2.5).floatValue();
        } else if (reps == 4) {
            return programCreator.mRound(max * 1.09, 2.5).floatValue();
        }
        return max;
    }

    private void showSession(Stage stage) {
        Text session = new Text(programCreator.program.get(currentSession));
        session.setStyle("-fx-font: normal bold 20px 'Courier New'");
        session.setTextAlignment(TextAlignment.CENTER);
        session.setFill(Color.WHITE);

        Button buttonNext = new Button("Next");
        buttonNext.setMinSize(175, 40);
        buttonNext.setStyle("-fx-font: normal bold 35px 'plain'");
        buttonNext.setOnAction(actionEvent -> nextSession(stage));

        Button buttonPrevious = new Button("Previous");
        buttonPrevious.setMinSize(175, 40);
        buttonPrevious.setStyle("-fx-font: normal bold 35px 'plain'");
        buttonPrevious.setOnAction(actionEvent -> previousSession(stage));

        HBox buttonsContainer = new HBox(buttonPrevious, buttonNext);
        buttonsContainer.setAlignment(Pos.CENTER);
        buttonsContainer.setSpacing(10);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(session);
        borderPane.setBottom(buttonsContainer);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1080, 2400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: black;");
        gridPane.getChildren().add(borderPane);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
