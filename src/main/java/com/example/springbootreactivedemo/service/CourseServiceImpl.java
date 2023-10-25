package com.example.springbootreactivedemo.service;

import com.example.springbootreactivedemo.entity.Course;
import com.example.springbootreactivedemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Flux<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Mono<Course> getCourse(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public Mono<Course> saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
