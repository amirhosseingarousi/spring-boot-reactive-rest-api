package com.example.springbootreactivedemo.controller;

import com.example.springbootreactivedemo.entity.Course;
import com.example.springbootreactivedemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public Flux<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public Mono<Course> getCourse(@PathVariable("id") int id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/save")
    public Mono<Course> saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
}
