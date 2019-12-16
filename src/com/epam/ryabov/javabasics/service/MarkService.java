package com.epam.ryabov.javabasics.service;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;

public interface MarkService {
    int studentSumMarks(Student student);

    Double averageStudentMark(Student student);

    String studyStatus(Student student);

    boolean potentialSuccessfulStudyEnd(Student student, TrainingCenter trainingCenter);
}
