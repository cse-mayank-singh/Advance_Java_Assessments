package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingRequest;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
@Slf4j
public class BookingController {

    private final BookingService bookingService;
    @PostMapping
    public ResponseEntity<Booking> bookTicket(@RequestBody BookingRequest request) {
        log.info("POST /bookings - movieId: {}, tickets: {}", request.getMovieId(), request.getTickets());
        Booking booking = bookingService.bookTicket(request);
        HttpStatus status = "CONFIRMED".equals(booking.getStatus()) ? HttpStatus.CREATED : HttpStatus.SERVICE_UNAVAILABLE;
        return ResponseEntity.status(status).body(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        log.info("GET /bookings - Retrieving all bookings");
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
