package com.example.demo.model;
public class Movie {
    private Long id;
    private String name;
    private String language;
    private double price;
    public Movie() {
    }
    public Movie(Long id, String name, String language, double price) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.price = price;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }
}