package com.example.demo.client;
import com.example.demo.model.MovieResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Component
@Slf4j
public class MovieClientFallback implements MovieServiceClient {
    @Override
    public MovieResponse getMovieById(Long id) {
        log.warn("CIRCUIT BREAKER TRIGGERED: Movie Service is unavailable for movieId={}. Returning fallback.", id);
        MovieResponse fallback = new MovieResponse();
        fallback.setId(id);
        fallback.setName("Service Unavailable");
        fallback.setLanguage("N/A");
        fallback.setPrice(0.0);
        return fallback;
    }
}
