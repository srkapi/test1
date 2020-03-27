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

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {

        return personList.get(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") int id, @RequestBody Person person){
        personList.set(id,person);
        return personList.get(id);
    }

    @DeleteMapping("/{id}")
    public List<Person> deletePerson(@PathVariable("id") int id){
        personList.remove(id);
        return personList;
    }

}
