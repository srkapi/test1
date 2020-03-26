package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    public Person savePerson() {
        Person person = new Person();

        person.setName("kapi");
        person.setSurname("iglesias");
        return person;
    }
    @GetMapping
    public Person getPerson(){
        Person person = new Person();
        person.getName();
        person.getSurname();
        return person;
    }


}
