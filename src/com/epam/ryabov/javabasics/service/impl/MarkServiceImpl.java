package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.service.MarkService;
import com.epam.ryabov.javabasics.service.StudyTimeService;

public class MarkServiceImpl implements MarkService {

    private StudyTimeService studyTimeService = new StudyTimeServiceImpl();

    @Override
    public int sumOfStudentSumMarks(Student student) {
        int sumMarks = 0;
        for (Integer mark : student.getStudentProgress()) {
            sumMarks += mark;
        }
        return sumMarks;
    }

    @Override
    public Double calcAverageStudentMark(Student student) {
        Double averageStudentMark = 0D;
        int markCount = 0;
        for (Integer mark : student.getStudentProgress()) {
            averageStudentMark += mark;
            markCount++;
        }
        return Math.round((averageStudentMark / markCount) * 10) / 10.0;
    }

    @Override
    public String checkStudyStatus(Student student, TrainingCenter trainingCenter) {
        if (calcAverageStudentMark(student) < trainingCenter.getMinAverageMark()) {
            return "С текущим средним баллом подлежит отчислению.";
        }
        return "С текущим средним баллом может продолжать обучение.";
    }

    @Override
    public boolean isStudentCanSuccessfulStudyEnd(Student student, TrainingCenter trainingCenter) {
        double nominator = sumOfStudentSumMarks(student) - trainingCenter.getMinAverageMark() * student.getStudentProgress().toArray().length;
        double denominator = trainingCenter.getMinAverageMark() - trainingCenter.getMaxMark();
        return nominator / denominator <= studyTimeService.calcStudentDaysUntilEndOfCurriculum(student, trainingCenter);
    }
}

