package com.example.demo.TrainingProgram.TrainingWeeks;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SecondWeek {

    public List<String> secondWeek = new ArrayList<>();

    private final ProgramCreator programCreator;
    public SecondWeek(ProgramCreator programCreator) {
        this.programCreator = programCreator;
        secondWeek.add(getNameOfWeek());
        secondWeek.add(getFirstDay());
        secondWeek.add(getSecondDay());
        secondWeek.add(getThirdDay());
        secondWeek.add(getFourthDay());
        secondWeek.add(getFifthDay());
    }

    public String getNameOfWeek() {
        return "Week 2 - Muscular Conditioning/Hypertrophy (W/ Higher Difficulty)";
    }

    public String getFirstDay() {
        Double squat = programCreator.mRound(programCreator.squatMax * 0.8, 2.5);
        String addon = """

                ----------------------------------------------------------
                |Extra Volume Squats - Add 2.5 kg, then perform          |
                |5 x 3  each set with 60 seconds rest between sets.      |
                ----------------------------------------------------------
                |Note - If you get below 8 reps, reduce max by 2.5%.     |
                ----------------------------------------------------------
                |Still complete the 5 sets of 3 reps regardless          |""";
        return getStringLower(squat, programCreator.date.plusDays(7), addon);
    }

    public String getSecondDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        return getStringUpper(spaceFirst, spaceSecond, spaceThird,
                programCreator.date.plusDays(8));

    }

    public String getThirdDay() {
        Double squat = programCreator.mRound(programCreator.squatMax * 0.8, 2.5) + 2.5;
        String addon = """

                ----------------------------------------------------------
                |Back Off Squats - Reduce weight by 5kg and proceed with:|
                ----------------------------------------------------------
                |If you did 10 reps, then do 10x3, with 60 seconds rest. |
                ----------------------------------------------------------
                |If you did 8-9 reps, then do 8x3, with 60 seconds rest. |
                ----------------------------------------------------------
                |If you did 7 reps, then do 5x3, with 60 seconds rest.   |
                ----------------------------------------------------------
                |If you did < 7 reps, then skip and reduce max by 2.5%.  |""";
        return getStringLower(squat, programCreator.date.plusDays(10), addon);
    }

    public String getFourthDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        return getStringUpper(spaceFirst, spaceSecond, spaceThird,
                programCreator.date.plusDays(11));
    }

    public String getFifthDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        LocalDate date = programCreator.date.plusDays(13);
        String benchFirst = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.8, 2.5) - 2.5)
                        .length() + 14);
        return "----------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                (programCreator.mRound(programCreator.benchMax * 0.8, 2.5) - 2.5) + benchFirst +
                "xMR  |-----------|-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|      x10  |       x8  |       x8  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|      x10  |       x8  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|      x10  |       x8  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------";
    }

    private String getStringUpper(String spaceFirst, String spaceSecond, String spaceThird, LocalDate date) {
        String benchFirst = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.725, 2.5))
                        .length() + 14);
        String benchSecond = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.775, 2.5))
                        .length() + 13);
        String benchThird = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.8, 2.5) +2.5)
                        .length() + 14);
        return "----------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                programCreator.mRound(programCreator.benchMax * 0.725, 2.5) + benchFirst
                + "x10  |" + programCreator.mRound(programCreator.benchMax * 0.775, 2.5) + benchSecond
                + "x8  |"
                + (programCreator.mRound(programCreator.benchMax * 0.8, 2.5) + 2.5) + benchThird +
                "x6-8 |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|      x10  |       x8  |       x8  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|      x10  |       x8  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|      x10  |       x8  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------";
    }

    private String getStringLower(Double squat, LocalDate date, String addon) {
        return "----------------------------------------------------------" +
                "\n" + "|     " + date + "     |Set 1      |Set 2 " +
                "     |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Squat               |" + squat +
                " xMR10|-----------|-----------|" + addon +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Deadlift Variation  |       x8  |       x8  |       x8  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |           |           |           |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |           |           |           |" +
                "\n" + "----------------------------------------------------------";
    }
}
