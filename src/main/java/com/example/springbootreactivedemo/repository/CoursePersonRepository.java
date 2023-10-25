package com.example.springbootreactivedemo.repository;

import com.example.springbootreactivedemo.entity.CoursePerson;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CoursePersonRepository extends ReactiveCrudRepository<CoursePerson, Integer> {
}
