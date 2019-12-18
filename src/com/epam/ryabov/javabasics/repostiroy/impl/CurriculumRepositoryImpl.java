package com.epam.ryabov.javabasics.repostiroy.impl;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Curriculum;
import com.epam.ryabov.javabasics.repostiroy.CurriculumRepository;

public class CurriculumRepositoryImpl implements CurriculumRepository {

    private Curriculum curriculum;

    @Override
    public boolean addCourse(Course course) {
        return curriculum.getCourseList().add(course);
    }

    @Override
    public boolean deleteCourse(Course course) {
        return curriculum.getCourseList().remove(course);
    }

    public CurriculumRepositoryImpl() {
    }

    public CurriculumRepositoryImpl(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public Curriculum getCurriculum() {
        return curriculum;
    }

    @Override
    public CurriculumRepository setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
        return this;
    }
}
