package com.example.springbootreactivedemo.repository;

import com.example.springbootreactivedemo.entity.Course;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CourseRepository extends ReactiveCrudRepository<Course, Integer> {
}
