package com.example.springbootreactivedemo.service;

import com.example.springbootreactivedemo.entity.Person;
import com.example.springbootreactivedemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Mono<Person> savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> getPerson(int id) {
        return personRepository.findById(id);
    }

    @Override
    public Flux<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
