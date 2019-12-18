package com.epam.ryabov.javabasics.service;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;

import java.time.LocalDate;

public interface StudyTimeService {

    Long calcStudentCurriculumDuration(Student student);

    LocalDate calcStudentEndCurriculumDate(Student student, TrainingCenter trainingCenter);

    long calcStudentDaysUntilEndOfCurriculum(Student student, TrainingCenter trainingCenter);

    Long calcStudentHoursUntilEndOfCurriculum(Student student, TrainingCenter trainingCenter);
}
