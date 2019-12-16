package com.epam.ryabov.javabasics.service;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;

import java.time.LocalDate;

public interface StudyTimeService {

    Long studentCurriculumDuration(Student student);

    LocalDate studentEndCurriculumDate(Student student, TrainingCenter trainingCenter);

    Long hoursUntilEndOfCurriculum(Student student, TrainingCenter trainingCenter);
}
