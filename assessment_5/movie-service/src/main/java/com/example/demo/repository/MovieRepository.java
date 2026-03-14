package com.example.demo.repository;
import com.example.demo.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public MovieRepository() {
        // Pre-load in-memory data
        movies.add(new Movie(1L, "Inception", "English", 250.0));
        movies.add(new Movie(2L, "Interstellar", "English", 280.0));
        movies.add(new Movie(3L, "The Dark Knight", "English", 300.0));
        movies.add(new Movie(4L, "RRR", "Telugu", 200.0));
        movies.add(new Movie(5L, "KGF Chapter 2", "Kannada", 220.0));
    }
    public List<Movie> findAll() {
        return movies;
    }
    public Optional<Movie> findById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }
}
