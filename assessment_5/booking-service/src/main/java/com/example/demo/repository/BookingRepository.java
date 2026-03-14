package com.example.demo.repository;
import com.example.demo.model.Booking;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class BookingRepository {

    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(100);

    public Booking save(Booking booking) {
        booking.setBookingId(idGenerator.incrementAndGet());
        bookings.add(booking);
        return booking;
    }

    public List<Booking> findAll() {
        return bookings;
    }
}
