package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.service.MarkService;
import com.epam.ryabov.javabasics.service.StudyTimeService;
import com.epam.ryabov.javabasics.service.TrainingCenterService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TrainingCenterServiceImpl implements TrainingCenterService {

    private MarkService markService = new MarkServiceImpl();
    private StudyTimeService studyTimeService = new StudyTimeServiceImpl();

    @Override
    public String addStudent(Student student, TrainingCenter trainingCenter) {
        List<Student> studentList = trainingCenter.getStudentList();
        studentList.add(student);
        trainingCenter.setStudentList(studentList);
        return "Студент добавлен";
    }

    @Override
    public List<Student> sortStudentByAverageMark(TrainingCenter trainingCenter) {
        return trainingCenter.getStudentList().stream().sorted(Comparator.comparing(o -> markService.calcAverageStudentMark(o))).collect(Collectors.toList());
    }

    @Override
    public List<Student> sortStudentByTimeUntilStudyEnd(TrainingCenter trainingCenter) {
        return trainingCenter.getStudentList().stream().sorted(Comparator.comparing(o -> studyTimeService.calcStudentHoursUntilEndOfCurriculum(o, trainingCenter))).collect(Collectors.toList());
    }

    @Override
    public List<Student> filterByChanceToSuccessfulCompleteCurriculum(TrainingCenter trainingCenter) {
        return trainingCenter.getStudentList().stream().filter(o -> markService.isStudentCanSuccessfulStudyEnd(o, trainingCenter)).collect(Collectors.toList());
    }

}
