package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    public Person savePerson() { // recibir por parametro un objeto java  y devolver el mismo object
        Person person = new Person();

        person.setName("kapi");
        person.setSurname("iglesias");
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
