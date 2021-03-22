package com.example.demo.api;
import com.example.demo.dao.BookingRepo;
import com.example.demo.models.Booking;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*@CrossOrigin(origins = "http://localhost:8081")*/
@RestController
@RequestMapping("/api")
public class BookingApi {
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
   BookingService bookingService;
    @GetMapping(value = "/getAllBookingRest")
    public List<Booking> getAll(){

        List<Booking> bookings = bookingService.getAllBooking();
        return  bookings;
    }

}