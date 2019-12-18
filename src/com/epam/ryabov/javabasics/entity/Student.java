package com.epam.ryabov.javabasics.entity;

import java.util.List;

public class Student {

    private Long id;
    private String surname;
    private String name;
    private Curriculum curriculum;
    private List<Integer> studentProgress;

    public Student(Long id, String surname, String name, Curriculum curriculum, List<Integer> studentProgress) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.curriculum = curriculum;
        this.studentProgress = studentProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public List<Integer> getStudentProgress() {
        return studentProgress;
    }

    public void setStudentProgress(List<Integer> studentProgress) {
        this.studentProgress = studentProgress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
