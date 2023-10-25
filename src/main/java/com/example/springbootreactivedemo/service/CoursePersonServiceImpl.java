package com.example.springbootreactivedemo.service;

import com.example.springbootreactivedemo.entity.Course;
import com.example.springbootreactivedemo.entity.CoursePerson;
import com.example.springbootreactivedemo.entity.Person;
import com.example.springbootreactivedemo.repository.CoursePersonRepository;
import com.example.springbootreactivedemo.repository.CourseRepository;
import com.example.springbootreactivedemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoursePersonServiceImpl implements CoursePersonService {

    @Autowired
    private CoursePersonRepository coursePersonRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Mono<CoursePerson> saveCoursePerson(int courseId, int personId) {
        return personRepository
                .findById(personId)
                .switchIfEmpty(Mono.error(new RuntimeException("person not found!")))
                .flatMap(person -> courseRepository
                        .findById(courseId)
                        .switchIfEmpty(Mono.error(new RuntimeException("course not found")))
                        .flatMap(course -> {
                            if (course.getCapacity().equals(0)) {
                                return Mono.error(new RuntimeException("capacity is full!"));
                            }
                            int capacity = course.getCapacity()-1;
                            course.setCapacity(capacity);
                            return courseRepository.save(course)
                                    .flatMap(course1 -> {
                                        CoursePerson coursePerson = new CoursePerson(courseId, personId);
                                        return coursePersonRepository
                                                .save(coursePerson);
                                    });
                        }));
    }

    @Override
    public Flux<CoursePerson> getAllCoursePerson() {
        return coursePersonRepository.findAll();
    }
}
