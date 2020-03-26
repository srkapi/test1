package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private List<Person> personList = new ArrayList<>();

    @PostMapping
    public Person savePerson(@RequestBody Person person) { // recibir por parametro un objeto java  y devolver el mismo object
        //Person person = new Person();
/*
        person.setName("kapi");
        person.setSurname("iglesias");*/
        return person;
    }


//    @GetMapping
//    public Person getPerson() {
//        Person person = new Person();
//        person.getName();
//        person.getSurname();
//        return person;
//    }


}
