package com.methaporce.model;

public class Movie {
    private Integer id;

    private String name;

    private Boolean available;

    public Movie(){
    }
    public Movie(Integer id,String name,Boolean available){
        this.id = id;
        this.name = name;
        this.available = available;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}

