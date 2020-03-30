package com.example.demo;

//ejemplo de herencia: la clase client hereda las operaciones de la clase person
//para ello se extiende una clase
//los atributos de la clase padre deben ser públicos o protegidos
public class Client extends Person {
        //private: accesible desde esa clase
        private String type;

        //constructor subclase
        public Client(){
            //invoca constructor de la superclase
            super();
    }
    //se usa la anotación @override para indicar que el método redefine uno de la superclase

}
