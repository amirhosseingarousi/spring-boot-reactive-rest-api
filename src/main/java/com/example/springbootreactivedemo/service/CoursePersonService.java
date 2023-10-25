package com.example.springbootreactivedemo.service;

import com.example.springbootreactivedemo.entity.CoursePerson;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursePersonService {

    Mono<CoursePerson> saveCoursePerson(int courseId, int personId);
    Flux<CoursePerson> getAllCoursePerson();
}
