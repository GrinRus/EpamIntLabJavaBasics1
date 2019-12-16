package com.epam.ryabov.javabasics.entity;

import java.util.List;

public class Student {

    private Long id;
    private String fio;
    private Curriculum curriculum;
    private List<Integer> studentProgress;

    public Student(Long id, String fio, Curriculum curriculum, List<Integer> studentProgress) {
        this.id = id;
        this.fio = fio;
        this.curriculum = curriculum;
        this.studentProgress = studentProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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
}
