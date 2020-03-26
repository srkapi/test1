package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    public Person savePerson() {
        Person person = new Person();
        person.setName("kapi");
        person.setSurname("iglesias");
        return new Person();
    }
}
