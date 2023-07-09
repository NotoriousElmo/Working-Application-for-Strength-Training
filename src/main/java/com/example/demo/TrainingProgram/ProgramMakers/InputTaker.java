package com.example.demo.TrainingProgram.ProgramMakers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputTaker {

    ProgramCreator program;

    public InputTaker() {

        float benchMax = getMax("What is your Bench Press max?");
        float squatMax = getMax("What is your Squat max?");
        float deadLiftMax = getMax("What is your Deadlift max?");

        String upperBackSecond = getExercise("""
                Which Upper Back horizontal pull exercise do you prefer?
                * Barbell Row
                * Dumbbell Row
                * Machine Row""");
        String shoulder = getExercise("""
                Which Upper Back horizontal pull exercise do you prefer?
                * Seated Dumbbell OHP
                * Standing Dumbbell OHP
                * Military Press
                * Lateral Dumbbell Raise""");
        String upperBackFirst = getExercise("""
                Which Upper Back horizontal pull exercise do you prefer?
                * Weighted Pull-up
                * Weighted Chin-up
                * Lat Pulldown""");

        LocalDate date = getStartDate();

        System.out.println("Creating the program...");

        program = new ProgramCreator(squatMax, deadLiftMax, benchMax,
                upperBackFirst, shoulder, upperBackSecond, date);
    }

    public ProgramCreator getProgram() {
        return program;
    }

    private LocalDate getStartDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your preferred start date (yyyy-MM-dd): ");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
        scanner.close();
        return date;
    }

    private float getMax(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String input = checkInputIsNumber(scanner);
        return Float.parseFloat(input);
    }

    private String getExercise(String options) {
        System.out.println(options);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String checkInputIsNumber(Scanner scanner) {
        String input = scanner.next();
        while (!isNumeric(input)) {
            System.out.println("Please enter a number.");
            input = scanner.nextLine();
        }
        return input;
    }

    public boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
