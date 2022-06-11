package com.javatechie.jpa.Learning;

public class People {

    private long id;
    private String name;


    private long address ;

    public People() {
    }

    public People(long id, String name, long address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public long getAddress() {
        Address a = new Address();
        a.setId(1000);
        return a.getId();
    }

    public void setAddress(long address) {
        this.address = address;
    }


}
