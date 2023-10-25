package com.example.springbootreactivedemo.service;

import com.example.springbootreactivedemo.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Mono<Person> savePerson(Person person );
    Mono<Person> getPerson(int id);
    Flux<Person> getAllPerson();
}
