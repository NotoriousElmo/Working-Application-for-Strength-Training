package com.example.demo.TrainingProgram.TrainingWeeks;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FirstWeek {

    public List<String> firstWeek = new ArrayList<>();

    private final ProgramCreator programCreator;
    public FirstWeek(ProgramCreator programCreator) {
        this.programCreator = programCreator;
        firstWeek.add(getNameOfWeek());
        firstWeek.add(getFirstDay());
        firstWeek.add(getSecondDay());
        firstWeek.add(getThirdDay());
        firstWeek.add(getFourthDay());
        firstWeek.add(getFifthDay());
    }

    public String getNameOfWeek() {
        return "Week 1 - Muscular Conditioning (W/ Moderate Difficulty)";
    }

    public String getFirstDay() {
        Double squat = programCreator.mRound(programCreator.squatMax * 0.8, 2.5);
        Double deadlift = programCreator.mRound(programCreator.deadLiftMax * 0.8, 2.5);
        return getStringLower(squat, deadlift, programCreator.date);
    }

    public String getSecondDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        return getStringUpper(spaceFirst, spaceSecond, spaceThird,
                programCreator.date.plusDays(1));

    }

    public String getThirdDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        return getStringUpper(spaceFirst, spaceSecond, spaceThird,
                programCreator.date.plusDays(3));
    }

    public String getFourthDay() {
        Double squat = programCreator.mRound(programCreator.squatMax * 0.7, 5);
        Double deadlift = programCreator.mRound(programCreator.deadLiftMax * 0.7, 5);
        return getStringLower(squat, deadlift, programCreator.date.plusDays(4));
    }

    public String getFifthDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        LocalDate date = programCreator.date.plusDays(5);
        String benchFirst = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.8, 2.5))
                        .length() + 14);
        return "----------------------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |Set 4      |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                programCreator.mRound(programCreator.benchMax * 0.8, 2.5) + benchFirst
                + "xMR  |-----------|-----------|-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|      x10  |      x10  |       x8  |       x6  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|      x12  |      x12  |      x10  |       x8  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|      x12  |      x12  |      x10  |       x8  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |    x8-12  |    x8-12  |    x8-12  |-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |    x8-12  |    x8-12  |    x8-12  |-----------|" +
                "\n" + "----------------------------------------------------------------------";
    }

    private String getStringUpper(String spaceFirst, String spaceSecond, String spaceThird, LocalDate date) {
        String benchFirst = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.5, 2.5))
                        .length() + 14);
        String benchSecond = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.675, 2.5))
                        .length() + 14);
        String benchThird = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.75, 2.5))
                        .length() + 13);
        String benchFourth = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.775, 2.5))
                        .length() + 13);
        return "----------------------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |Set 4      |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                programCreator.mRound(programCreator.benchMax * 0.5, 2.5) + benchFirst
                + "x10  |" + programCreator.mRound(programCreator.benchMax * 0.675, 2.5)
                + benchSecond + "x10  |"
                + programCreator.mRound(programCreator.benchMax * 0.75, 2.5)
                + benchThird + "x8  |" +
                programCreator.mRound(programCreator.benchMax * 0.775, 2.5)
                + benchFourth + "x6  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|      x10  |      x10  |       x8  |       x6  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|      x12  |      x12  |      x10  |       x8  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|      x12  |      x12  |      x10  |       x8  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |    x8-12  |    x8-12  |    x8-12  |-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |    x8-12  |    x8-12  |    x8-12  |-----------|" +
                "\n" + "----------------------------------------------------------------------";
    }

    private String getStringLower(Double squat, Double deadlift, LocalDate date) {
        return "----------------------------------------------------------------------" +
                "\n" + "|     " + date + "     |Set 1      |Set 2 " +
                "     |Set 3      |Set 4      |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Squat               | " + squat + " x8  | " + squat + " x8  | "
                + squat + " x8  | " + squat + " x8  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Deadlift            | " + deadlift + " x8  | " + deadlift +
                " x8  |-----------|-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |           |           |           |-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |           |           |           |-----------|" +
                "\n" + "----------------------------------------------------------------------";
    }
}
