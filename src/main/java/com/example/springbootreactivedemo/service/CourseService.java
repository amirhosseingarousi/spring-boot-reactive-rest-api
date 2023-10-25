package com.example.springbootreactivedemo.service;

import com.example.springbootreactivedemo.entity.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    Flux<Course> getAllCourse();
    Mono<Course> getCourse(int id);
    Mono<Course> saveCourse(Course course);
}
