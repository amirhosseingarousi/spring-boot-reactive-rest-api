package com.example.springbootreactivedemo.controller;

import com.example.springbootreactivedemo.entity.CoursePerson;
import com.example.springbootreactivedemo.service.CoursePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course-person")
public class CoursePersonController {

    @Autowired
    private CoursePersonService coursePersonService;


    @PostMapping("/save/{courseId}/{personId}")
    public Mono<CoursePerson> saveCoursePerson(@PathVariable("courseId") int courseId,
                                               @PathVariable("personId") int personId) {
        return coursePersonService.saveCoursePerson(courseId, personId);
    }

    @GetMapping("/all")
    public Flux<CoursePerson> getAllPersonCourse() {
        return coursePersonService.getAllCoursePerson();
    }

}
