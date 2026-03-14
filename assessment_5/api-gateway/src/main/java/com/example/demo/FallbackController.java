package com.example.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/movies")
    public ResponseEntity<Map<String, String>> movieFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", "SERVICE_UNAVAILABLE",
                        "message", "Movie Service is currently down. Please try again later.",
                        "service", "movie-service"
                ));
    }
    @GetMapping("/bookings")
    public ResponseEntity<Map<String, String>> bookingFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "status", "SERVICE_UNAVAILABLE",
                        "message", "Booking Service is currently down. Please try again later.",
                        "service", "booking-service"
                ));
    }
}
