package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.service.StudyTimeService;

import java.time.LocalDate;
import java.util.List;

public class StudyTimeServiceImpl implements StudyTimeService {

    @Override
    public Long calcStudentCurriculumDuration(Student student) {
        List<Course> courseList = student.getCurriculum().getCourseList();
        long res = 0L;
        for (Course course : courseList) {
            res += course.getDurationHours();
        }
        return res;
    }

    @Override
    public LocalDate calcStudentEndCurriculumDate(Student student, TrainingCenter trainingCenter) {
        long curriculumDuration = calcStudentCurriculumDuration(student) / trainingCenter.getDurationStudyTime();
        return student.getCurriculum().getStartDate().plusDays(curriculumDuration);
    }

    @Override
    public long calcStudentDaysUntilEndOfCurriculum(Student student, TrainingCenter trainingCenter) {
        return LocalDate.now().until(calcStudentEndCurriculumDate(student, trainingCenter)).getDays();
    }

    @Override
    public Long calcStudentHoursUntilEndOfCurriculum(Student student, TrainingCenter trainingCenter) {
        return calcStudentDaysUntilEndOfCurriculum(student, trainingCenter) * trainingCenter.getDurationStudyTime();
    }
}
