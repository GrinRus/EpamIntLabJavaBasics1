package com.epam.ryabov.javabasics.repostiroy;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Curriculum;

public interface CurriculumRepository {

    boolean addCourse(Course course);

    boolean deleteCourse(Course course);

    Curriculum getCurriculum();

    CurriculumRepository setCurriculum(Curriculum curriculum);
}
