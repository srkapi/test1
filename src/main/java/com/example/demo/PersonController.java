package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private List<Person> personList = new ArrayList<>();
    // cambiar list por map
    //En java 8: Map<Integer,Person> mapa = personList.stream().collect(Collectors.toMap(x->x.getId(),x->x));
    // duda: si en una lista hay elementos repetidos, al convertirla a un mapa con cual elemento se queda?

    // diferencias entre mapa y list
    /* mapa -> la interfaz map asocia claves a valores, siendo que para una clave
      solo hay un valor y las claves no pueden ser duplicadas. Map<clave, valor>
      LAs implementaciones de los mapas son: HashMap, TreeMap y HashTable.

        list-> la interfaz list define varios elementos sucesivos, es decir, tienen una secuencia ordenada
        y admite elementos duplicados.  Se accede a los elementos por su posición en la lista.
        Sus implementaciones son: ArrrayList, Vector y LinkedList
      */

    // diferencia entre lista y queue
        /* Queue (colas) son listas donde las inserciones se hacen al final
        y las extracciones se hacen al principio
        FIFO (First In First Out = primero en entrar primero en salir)
        implementa la LinkedList
        * */

    // buscar composicion en java
    /* La composición consiste en crear una clase nueva agrupando objetos de otras
    ya existentes.
    De modo que habrá atributos de la clase contenedora que serán objetos de la clase contenida:
    ejemplo:
            public class Person{
                    private int id;
                    private String name;
            }
            public class BookLending{
                    private Person person;
                    private Book book;
                    private int total;
            }
    * */

    // interface  en java?? concepto
    /* El interface es una lista de métodos (acciones) que un objeto lleva a cabo.
        solo aparece la llamada al método no su código.
        una clase implementa una interfaz
     */


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

        return personList.set(id, person);
    }

    @DeleteMapping("/{id}")
    public List<Person> deletePerson(@PathVariable("id") int id){
        personList.remove(id);
        return personList;
    }

}
