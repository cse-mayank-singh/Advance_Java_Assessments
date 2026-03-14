package com.example.demo.model;
import lombok.Data;
@Data
public class MovieResponse {
    private Long id;
    private String name;
    private String language;
    private double price;
}