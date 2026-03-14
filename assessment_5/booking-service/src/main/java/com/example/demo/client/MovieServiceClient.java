package com.example.demo.client;
import com.example.demo.model.MovieResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(
    name = "movie-service",
    fallback = MovieClientFallback.class
)
public interface MovieServiceClient {
    @GetMapping("/movies/{id}")
    MovieResponse getMovieById(@PathVariable("id") Long id);
}