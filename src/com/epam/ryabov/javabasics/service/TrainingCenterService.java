package com.epam.ryabov.javabasics.service;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;

import java.util.List;

public interface TrainingCenterService {

    String addStudent(Student student, TrainingCenter trainingCenter);

    List<Student> sortStudentByAverageMark(TrainingCenter trainingCenter);

    List<Student> sortStudentByTimeUntilStudyEnd(TrainingCenter trainingCenter);

    List<Student> filterByChanceToSuccessfulCompleteCurriculum(TrainingCenter trainingCenter);
}
