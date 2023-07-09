package com.example.demo.TrainingProgram.TrainingWeeks;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FifthWeek {

    public List<String> fifthWeek = new ArrayList<>();

    private final ProgramCreator programCreator;

    public FifthWeek(ProgramCreator programCreator) {
        this.programCreator = programCreator;
        fifthWeek.add(getNameOfWeek());
        fifthWeek.add(getFirstDay());
        fifthWeek.add(getSecondDay());
        fifthWeek.add(getThirdDay());
    }

    public String getNameOfWeek() {
        return "Week 5 - High Intensity Strength";
    }

    public String getFirstDay() {
        LocalDate date = programCreator.date.plusDays(28);
        Double squat = programCreator
                .mRound(programCreator.squatMax * 0.975, 2.5);
        return "----------------------------------------------------------" +
                "\n" + "|     " + date + "     |Set 1      |Set 2 " +
                "     |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Squat               |" + squat + " x1-4 |-----------|-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Deadlift            |"
                + programCreator.mRound(programCreator.deadLiftMax * 0.675, 2.5)
                + "  x4  |"
                + programCreator.mRound(programCreator.deadLiftMax * 0.7, 2.5)
                + "  x4  |"
                + programCreator.mRound(programCreator.deadLiftMax * 0.725, 2.5)
                + "  x2  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |           |           |           |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |           |           |           |" +
                "\n" + "----------------------------------------------------------";
    }

    public String getSecondDay() {
        String benchFirst = programCreator
                .getSpace(String.valueOf(programCreator
                        .mRound(programCreator.benchMax * 0.975, 2.5))
                        .length() + 14);
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        LocalDate date = programCreator.date.plusDays(30);
        return "----------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                programCreator.mRound(programCreator.benchMax * 0.975, 2.5) + benchFirst
                + "x1-4 |-----------|-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|       x8  |       x6  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|       x8  |       x6  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|       x8  |       x6  |       x6  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------";
    }

    public String getThirdDay() {
        LocalDate date = programCreator.date.plusDays(32);
        Double deadLift = programCreator
                .mRound(programCreator.deadLiftMax * 0.975, 2.5);
        return "----------------------------------------------------------" +
                "\n" + "|     " + date + "     |Set 1      |Set 2 " +
                "     |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Deadlift            |" + deadLift + " x1-4 |-----------|-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |           |           |           |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |           |           |           |" +
                "\n" + "----------------------------------------------------------";
    }
}
