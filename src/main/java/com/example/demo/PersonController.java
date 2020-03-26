package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private List<Person> personList = new ArrayList<>();

    @PostMapping
    public List<Person> savePerson(@RequestBody Person person) { // recibir por parametro un objeto java  y devolver el mismo object
        personList.add(person);

           return personList;

    }


    @GetMapping
    public Person getPerson(Person person) {

        return person;
    }

}
