package com.example.demo;


import java.io.Serializable;

public class Person implements Serializable {
    //protected: accesible desde sus subclases y desde cualquier clase en el mismo package
    protected int id;
    protected String name;
    protected String surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
