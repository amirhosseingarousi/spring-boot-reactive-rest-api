package com.example.springbootreactivedemo.controller;

import com.example.springbootreactivedemo.entity.Person;
import com.example.springbootreactivedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public Flux<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") int id) {
        return personService.getPerson(id);
    }

    @PostMapping("/save")
    public Mono<Person> savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
