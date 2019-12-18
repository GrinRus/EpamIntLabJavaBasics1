package com.epam.ryabov.javabasics.entity;

public class Course {

    private Long id;
    private String name;
    private Long durationHours;

    public Course(Long id, String name, Long durationHours) {
        this.id = id;
        this.name = name;
        this.durationHours = durationHours;
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

    public Long getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Long durationHours) {
        this.durationHours = durationHours;
    }

}
