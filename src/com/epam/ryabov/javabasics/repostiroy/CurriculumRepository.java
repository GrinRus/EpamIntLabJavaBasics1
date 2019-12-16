package com.epam.ryabov.javabasics.repostiroy;

import com.epam.ryabov.javabasics.entity.Course;
import com.epam.ryabov.javabasics.entity.Curriculum;

public interface CurriculumRepository {

    String addCourse(Course course, Curriculum curriculum);

    String deleteCourse(Course course, Curriculum curriculum);
}
