package com.javatechie.jpa.Learning;

import javax.print.attribute.standard.MediaSizeName;

public class Address {

    private long id;
    private String name;


    public Address(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
