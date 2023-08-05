package com.example.demo.TrainingProgram.ProgramMakers;

import com.example.demo.TrainingProgram.TrainingWeeks.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramCreator implements Serializable {

    public float squatMax;
    public float deadLiftMax;
    public float benchMax;
    public String upperBackFirst;
    public String shoulder;
    public String upperBackSecond;
    public Integer currentSession;
    public LocalDate date;
    public List<List<String>> programBlueprint = new ArrayList<>();
    public List<String> program = new ArrayList<>();


    public ProgramCreator(float squatMax, float deadLiftMax, float benchMax,
                          String upperBackFirst, String shoulder, String upperBackSecond,
                          LocalDate date) {
        this.squatMax = squatMax;
        this.deadLiftMax = deadLiftMax;
        this.benchMax = benchMax;
        this.upperBackFirst = upperBackFirst;
        this.shoulder = shoulder;
        this.upperBackSecond = upperBackSecond;
        this.date = date;
        createWeeks();
    }

    public Double mRound(double number, double multiple) {
        return Math.round(number / multiple) * multiple;
    }

    private void createWeeks() {
        FirstWeek firstWeek = new FirstWeek(this);
        SecondWeek secondWeek = new SecondWeek(this);
        ThirdWeek thirdWeek = new ThirdWeek(this);
        FourthWeek fourthWeek = new FourthWeek(this);
        FifthWeek fifthWeek = new FifthWeek(this);
        programBlueprint.add(firstWeek.firstWeek);
        programBlueprint.add(secondWeek.secondWeek);
        programBlueprint.add(thirdWeek.thirdWeek);
        programBlueprint.add(fourthWeek.fourthWeek);
        programBlueprint.add(fifthWeek.fifthWeek);
        for (List<String> week : programBlueprint) {
            program.addAll(week);
        }
    }
    public String getSpace(Integer length) {
        return " ".repeat(Math.max(0, 20 - length));
    }
}
