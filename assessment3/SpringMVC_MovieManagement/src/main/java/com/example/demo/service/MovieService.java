package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
    public Movie updateMovie(Long id, Movie movie) {
        Movie existing = movieRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(movie.getTitle());
            existing.setGenre(movie.getGenre());
            existing.setDirector(movie.getDirector());
            existing.setReleaseYear(movie.getReleaseYear());
            existing.setRating(movie.getRating());
            return movieRepository.save(existing);
        }
        return null;
    }
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}