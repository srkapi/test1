package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Person person = new Person();
		person = getObjectData(person);
		ObjectMapper Obj = new ObjectMapper();
		try {

			// get Person object as a json string
			String jsonStr = Obj.writeValueAsString(person);

			// Displaying JSON String
			System.out.println(jsonStr);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Person getObjectData(Person person){
		person.setName("Pricila");
		person.setSurname("Alves");
		return person;
	}


}
