package com.epam.ryabov.javabasics.entity;

import java.time.Duration;
import java.util.List;

public class TrainingCenter {

    private String name;
    private List<Student> studentList;
    private Duration durationStudyTime;

    public TrainingCenter(String name, List<Student> studentList, Duration durationStudyTime) {
        this.name = name;
        this.studentList = studentList;
        this.durationStudyTime = durationStudyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Duration getDurationStudyTime() {
        return durationStudyTime;
    }

    public void setDurationStudyTime(Duration durationStudyTime) {
        this.durationStudyTime = durationStudyTime;
    }
}
