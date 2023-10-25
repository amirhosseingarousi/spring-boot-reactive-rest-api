package com.example.springbootreactivedemo.repository;

import com.example.springbootreactivedemo.entity.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {
}
