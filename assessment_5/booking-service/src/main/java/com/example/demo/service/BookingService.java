package com.example.demo.service;
import com.example.demo.client.MovieServiceClient;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.model.MovieResponse;
import com.example.demo.repository.BookingRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class BookingService {
    private final BookingRepository bookingRepository;
    private final MovieServiceClient movieServiceClient;
    @CircuitBreaker(name = "movieServiceCB", fallbackMethod = "bookingFallback")
    public Booking bookTicket(BookingRequest request) {
        log.info("Booking ticket - movieId: {}, tickets: {}", request.getMovieId(), request.getTickets());
        MovieResponse movie = movieServiceClient.getMovieById(request.getMovieId());
        if ("Service Unavailable".equals(movie.getName())) {
            return createFailedBooking(request, "Movie Service is currently unavailable");
        }
        double total = movie.getPrice() * request.getTickets();
        Booking booking = new Booking();
        booking.setMovieId(request.getMovieId());
        booking.setMovieName(movie.getName());
        booking.setTickets(request.getTickets());
        booking.setTotalAmount(total);
        booking.setStatus("CONFIRMED");
        Booking saved = bookingRepository.save(booking);
        log.info("Booking CONFIRMED: bookingId={}, movie={}, total={}", saved.getBookingId(), movie.getName(), total);
        return saved;
    }
    public Booking bookingFallback(BookingRequest request, Throwable ex) {
        log.error("CIRCUIT BREAKER FALLBACK activated. Cause: {}", ex.getMessage());
        return createFailedBooking(request, "Movie Service is down. Please try again later.");
    }
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    private Booking createFailedBooking(BookingRequest request, String reason) {
        Booking failed = new Booking();
        failed.setBookingId(-1L);
        failed.setMovieId(request.getMovieId());
        failed.setMovieName("UNKNOWN - " + reason);
        failed.setTickets(request.getTickets());
        failed.setTotalAmount(0.0);
        failed.setStatus("FAILED");
        return failed;
    }
}