package com.epam.ryabov.javabasics.repostiroy.impl;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Curriculum;
import com.epam.ryabov.javabasics.repostiroy.CurriculumRepository;

public class CurriculumRepositoryImpl implements CurriculumRepository {

    @Override
    public String addCourse(Course course, Curriculum curriculum) {
        curriculum.getCourseList().add(course);
        return "Add complete";
    }

    @Override
    public String deleteCourse(Course course, Curriculum curriculum) {
        curriculum.getCourseList().remove(course);
        return "Delete complete";
    }
}
