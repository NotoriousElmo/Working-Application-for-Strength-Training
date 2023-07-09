package com.example.demo.TrainingProgram.TrainingWeeks;

import com.example.demo.TrainingProgram.ProgramMakers.ProgramCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FourthWeek {

    public List<String> fourthWeek = new ArrayList<>();

    private final ProgramCreator programCreator;
    public FourthWeek(ProgramCreator programCreator) {
        this.programCreator = programCreator;
        fourthWeek.add(getNameOfWeek());
        fourthWeek.add(getFirstDay());
        fourthWeek.add(getSecondDay());
        fourthWeek.add(getThirdDay());
        fourthWeek.add(getFourthDay());
    }

    public String getNameOfWeek() {
        return "Week 4 - Heavy Weight Acclimation";
    }

    public String getFirstDay() {
        return "----------------------------------------------------------" +
                "\n" + "|     " + programCreator.date.plusDays(21) +
                "     |Set 1      |Set 2      |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Squat               |" +
                (programCreator.mRound(programCreator.squatMax * 0.9, 2.5) - 2.5) + "  x3  |" +
                (programCreator.mRound(programCreator.squatMax * 0.9, 2.5)) + "  x3  |" +
                (programCreator.mRound(programCreator.squatMax * 0.9, 2.5) + 2.5) + "  x3  |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Deadlift Variation  |       x6  |       x6  |-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |           |           |           |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |           |           |           |" +
                "\n" + "----------------------------------------------------------";
    }

    public String getSecondDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        LocalDate date = programCreator.date.plusDays(22);
        float bench = programCreator.benchMax;
        Double benchFirst = programCreator.mRound(bench * 0.875 - 5, 2.5);
        Double benchSecond = programCreator.mRound(bench * 0.9 - 5, 2.5);
        Double benchThird = programCreator.mRound(bench * 0.9, 2.5);

        return "----------------------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |Set 4      |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                benchFirst + programCreator.getSpace(String.valueOf(benchFirst).length() + 13)
                + "x3  |" + benchSecond + programCreator.getSpace(String.valueOf(benchSecond).length() + 13)
                + "x3  |"
                + benchThird + programCreator.getSpace(String.valueOf(benchThird).length() + 13)
                + "x3  |-----------|" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackFirst + spaceFirst +
                "|      x10  |      x10  |      x8   |      x6   |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.shoulder + spaceSecond +
                "|      x12  |      x12  |      x10  |      x8   |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|" + programCreator.upperBackSecond + spaceThird +
                "|      x12  |      x12  |      x10  |      x8   |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |    x8-12  |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |    x8-12  |    x8-12  |    x8-12  |    x8-12  |" +
                "\n" + "----------------------------------------------------------------------";
    }

    public String getThirdDay() {
        return "----------------------------------------------------------" +
                "\n" + "|     " + programCreator.date.plusDays(24) +
                "     |Set 1      |Set 2      |Set 3      |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Squat               |" +
                (programCreator.mRound(programCreator.squatMax * 0.9, 2.5) + 2.5) + "  x3  |" +
                (programCreator.mRound(programCreator.squatMax * 0.95, 2.5)) + " x1-2 |-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Deadlift            |" +
                (programCreator.mRound(programCreator.deadLiftMax * 0.9, 2.5) + 2.5)
                + "  x3  |" + programCreator.mRound(programCreator.deadLiftMax * 0.95, 2.5)
                + " x1-2 |-----------|" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 1 |           |           |           |" +
                "\n" + "----------------------------------------------------------" +
                "\n" + "|Optional Exercise 2 |           |           |           |" +
                "\n" + "----------------------------------------------------------";
    }

    public String getFourthDay() {
        String spaceFirst = programCreator.getSpace(programCreator.upperBackFirst.length());
        String spaceSecond = programCreator.getSpace(programCreator.shoulder.length());
        String spaceThird = programCreator.getSpace((programCreator.upperBackSecond.length()));
        LocalDate date = programCreator.date.plusDays(25);
        float bench = programCreator.benchMax;
        Double benchFirst = programCreator.mRound(bench * 0.875, 2.5);
        Double benchSecond = programCreator.mRound(bench * 0.9, 2.5);
        Double benchThird = programCreator.mRound(bench * 0.95, 2.5);

        return "----------------------------------------------------------------------" +
                "\n" + "|     " + date +
                "     |Set 1      |Set 2      |Set 3      |Set 4      |" +
                "\n" + "----------------------------------------------------------------------" +
                "\n" + "|Bench Press         |" +
                programCreator.mRound(bench * 0.875, 2.5) +
                programCreator.getSpace(String.valueOf(benchFirst).length() + 13)
                + "x3  |" + programCreator.mRound(bench * 0.9, 2.5)
                + programCreator.getSpace(String.valueOf(benchSecond).length() + 14) + "x2-4 |"
                + programCreator.mRound(programCreator.benchMax * 0.95, 2.5)
                + programCreator.getSpace(String.valueOf(benchThird).length() + 14) + "x1-2 |-----------|" +
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
}



