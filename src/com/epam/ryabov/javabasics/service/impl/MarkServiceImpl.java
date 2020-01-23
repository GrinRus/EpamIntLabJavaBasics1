package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.service.MarkService;
import com.epam.ryabov.javabasics.service.StudyTimeService;

public class MarkServiceImpl implements MarkService {

    private StudyTimeService studyTimeService = new StudyTimeServiceImpl();

    @Override
    public int sumOfStudentSumMarks(Student student) {
        return student.getStudentProgress().stream().mapToInt(integer -> integer).sum();
    }

    @Override
    public Double calcAverageStudentMark(Student student) {
        double averageStudentMark = student.getStudentProgress().stream().mapToInt(integer -> integer).sum();
        int markCount = student.getStudentProgress().size();
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

