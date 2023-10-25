package com.example.springbootreactivedemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "course_person")
public class CoursePerson {

    @Id
    private Integer id;
    private Integer courseId;
    private Integer personId;

    public CoursePerson(Integer courseId, Integer personId) {
        this.courseId = courseId;
        this.personId = personId;
    }

    public CoursePerson() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
