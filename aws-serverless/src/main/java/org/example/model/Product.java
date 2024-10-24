package org.example.model;

public class Product {
    private int id;
    private String name;

    public Product(){}

    public Product(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}
