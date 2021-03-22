package com.example.demo.api;

import com.example.demo.dao.BookingDetailRepo;
import com.example.demo.dao.BookingRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.BookingDetail;
import com.example.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*@CrossOrigin(origins = "http://localhost:8081")*/
@RestController
@RequestMapping("/api")
public class BookingDetailApi {
    @Autowired
    BookingDetailRepo bookingDetailRepo;

    @Autowired
   BookingService bookingService;
    @GetMapping(value = "/getAllBookingDeatilRest")
    public List<BookingDetail> getAll(){

        List<BookingDetail> bookingsDetail = bookingDetailRepo.getAll();
        return  bookingsDetail;
    }

}