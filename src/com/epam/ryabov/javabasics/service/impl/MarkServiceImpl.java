package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.service.MarkService;
import com.epam.ryabov.javabasics.service.StudyTimeService;

public class MarkServiceImpl implements MarkService {

    private StudyTimeService studyTimeService = new StudyTimeServiceImpl();

    @Override
    public int studentSumMarks(Student student) {
        int sumMarks = 0;
        for (Integer mark : student.getStudentProgress()) {
            sumMarks += mark;
        }
        return sumMarks;
    }

    @Override
    public Double averageStudentMark(Student student) {
        Double averageStudentMark = 0D;
        int markCount = 0;
        for (Integer mark : student.getStudentProgress()) {
            averageStudentMark += mark;
            markCount++;
        }
        return Math.round((averageStudentMark / markCount) * 10) / 10.0;
    }

    @Override
    public String studyStatus(Student student) {
        if (averageStudentMark(student) < 4.5) {
            return "С текущим средним баллом подлежит отчислению.";
        }
        return "С текущим средним баллом может продолжать обучение.";
    }

    @Override
    public boolean potentialSuccessfulStudyEnd(Student student, TrainingCenter trainingCenter) {
        int studyDaysToEnd = (int) (studyTimeService.hoursUntilEndOfCurriculum(student, trainingCenter) / trainingCenter.getDurationStudyTime().toHours());
        return (4.5 * student.getStudentProgress().toArray().length - studentSumMarks(student)) / 0.5 <= studyDaysToEnd;
    }
}

