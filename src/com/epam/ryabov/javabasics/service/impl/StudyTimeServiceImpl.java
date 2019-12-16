package com.epam.ryabov.javabasics.service.impl;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Student;
import com.epam.ryabov.javabasics.entity.TrainingCenter;
import com.epam.ryabov.javabasics.service.StudyTimeService;

import java.time.LocalDate;
import java.util.List;

public class StudyTimeServiceImpl implements StudyTimeService {

    @Override
    public Long studentCurriculumDuration(Student student) {
        List<Course> courseList = student.getCurriculum().getCourseList();
        long res = 0L;
        for (Course course : courseList) {
            res += course.getDuration().toHours();
        }
        return res;
    }

    @Override
    public LocalDate studentEndCurriculumDate(Student student, TrainingCenter trainingCenter) {
        long curriculumDuration = studentCurriculumDuration(student) / trainingCenter.getDurationStudyTime().toHours();
        return student.getCurriculum().getStartDate().plusDays(curriculumDuration);
    }

    @Override
    public Long hoursUntilEndOfCurriculum(Student student, TrainingCenter trainingCenter) {
        return (long) (LocalDate.now().until(studentEndCurriculumDate(student, trainingCenter)).getDays()) * trainingCenter.getDurationStudyTime().toHours();
    }
}
