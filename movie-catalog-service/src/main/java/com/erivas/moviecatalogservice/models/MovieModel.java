package com.erivas.moviecatalogservice.models;

public class MovieModel {
    private Integer id;
    private String name;

    // Empty constructor that parses the request in the controller to an object
    public MovieModel() {
    }

    public MovieModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
