package com.epam.ryabov.javabasics.entity;

import java.time.Duration;

public class Course {

    private Long id;
    private String name;
    private Duration duration;

    public Course(Long id, String name, Duration duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
