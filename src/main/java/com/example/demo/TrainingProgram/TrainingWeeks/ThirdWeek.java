package com.example.demo.TrainingProgram.TrainingWeeks;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ThirdWeek {

    public List<String> thirdWeek = new ArrayList<>();

    private final ProgramCreator programCreator;
    public ThirdWeek(ProgramCreator programCreator) {
        this.programCreator = programCreator;
        thirdWeek.add(getNameOfWeek());
        thirdWeek.add(getFirstDay());
        thirdWeek.add(getSecondDay());
        thirdWeek.add(getThirdDay());
        thirdWeek.add(getFourthDay());
    }

    public String getNameOfWeek() {
        return "Week 3 - Linear Max OT Phase";
    }

    public String getFirstDay() {
        Double squat = programCreator.mRound(programCreator.squatMax * 0.85, 2.5) + 2.5;
        Double deadlift = programCreator.mRound(programCreator.deadLiftMax * 0.875, 2.5);
        return getStringLower(squat, deadlift, programCreator.date.plusDays(14));
    }

    public String getSecondDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        Double bench = programCreator
                .mRound(programCreator.benchMax * 0.85, 2.5);
        return getStringUpper(bench, spaceFirst, spaceSecond, spaceThird,
                programCreator.date.plusDays(16));

    }

    public String getThirdDay() {
        double squat = programCreator.mRound(programCreator.squatMax * 0.85 + 2.5, 2.5) + 2.5;
        return "----------------------------------" +
                "\n" + "|     " + programCreator.date.plusDays(18) + "     |Set 1      |" +
                "\n" + "----------------------------------" +
                "\n" + "|Squat               |" + squat + " x4-6 |" +
                "\n" + "----------------------------------" +
                "\n" + "|Deadlift Variation  |       x8  |" +
                "\n" + "----------------------------------";
    }

    public String getFourthDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        Double bench = programCreator
                .mRound(programCreator.benchMax * 0.85, 2.5) + 2.5;
        return getStringUpper(bench, spaceFirst, spaceSecond, spaceThird,
                programCreator.date.plusDays(19));
    }

    private String getStringUpper(Double bench, String spaceFirst, String spaceSecond, String spaceThird, LocalDate date) {
        String benchFirst = programCreator.getSpace(String.valueOf(bench).length() + 14);

        return "----------------------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |Set 4      |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Bench Press         |" + bench + benchFirst + "x4-6 |" + bench + benchFirst + "x4-6 |"
                + bench + benchFirst + "x4-6 |" + bench + benchFirst + "x4-6 |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|       x6  |       x6  |       x6  |-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|       x6  |       x6  |       x6  |-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|       x6  |       x6  |       x6  |-----------|" +
                "\n" + "----------------------------------------------------------------------";
    }

    private String getStringLower(Double squat, Double deadlift, LocalDate date) {
        return "----------------------------------------------------------" +
                "\n" + "|     " + date + "     |Set 1      |Set 2 " +
                "     |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Squat               |" + squat + " x4-6 |" + squat + " x4-6 |" + squat + " x4-6 |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Deadlift            |" + deadlift + " x3-6 |" + deadlift + " x3-6 |-----------|" +
                "\n" + "----------------------------------------------------------";
    }
}
