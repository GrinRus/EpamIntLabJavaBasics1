package com.epam.ryabov.javabasics.entity;

import java.util.List;

public class TrainingCenter {

    private String name;
    private List<Student> studentList;
    private Long durationStudyTime;
    private double minAverageMark;
    private int maxMark;

    public TrainingCenter(String name, List<Student> studentList, Long durationStudyTime, double minAverageMark, int maxMark) {
        this.name = name;
        this.studentList = studentList;
        this.durationStudyTime = durationStudyTime;
        this.minAverageMark = minAverageMark;
        this.maxMark = maxMark;
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

    public Long getDurationStudyTime() {
        return durationStudyTime;
    }

    public void setDurationStudyTime(Long durationStudyTime) {
        this.durationStudyTime = durationStudyTime;
    }

    public double getMinAverageMark() {
        return minAverageMark;
    }

    public void setMinAverageMark(double minAverageMark) {
        this.minAverageMark = minAverageMark;
    }

    public int getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(int maxMark) {
        this.maxMark = maxMark;
    }
}
