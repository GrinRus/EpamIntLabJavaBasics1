package com.epam.ryabov.javabasics.service;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;

public interface MarkService {
    int sumOfStudentSumMarks(Student student);

    Double calcAverageStudentMark(Student student);

    String checkStudyStatus(Student student, TrainingCenter trainingCenter);

    boolean isStudentCanSuccessfulStudyEnd(Student student, TrainingCenter trainingCenter);
}
