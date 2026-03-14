package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MovieService {

    private static final Logger log = Logger.getLogger(MovieService.class.getName());

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        log.info("Fetching all movies");
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        log.info("Fetching movie with id: " + id);
        return movieRepository.findById(id);
    }
}