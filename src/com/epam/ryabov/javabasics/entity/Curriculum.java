package com.epam.ryabov.javabasics.entity;

import java.time.LocalDate;
import java.util.List;

public class Curriculum {

    private Long id;
    private String name;
    private List<Course> courseList;
    private LocalDate startDate;

    public Curriculum(Long id, String name, List<Course> courseList, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.courseList = courseList;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
