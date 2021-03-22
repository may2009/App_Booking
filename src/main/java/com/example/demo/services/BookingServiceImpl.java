package com.example.demo.services;
import com.example.demo.dao.BookingRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.Hotel;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Value("${demo.url}")
    private String url;
    @Autowired
    BookingRepo bookingRepo;
    @Override
    public List<Booking> getAllBooking() {
       /* final String uri = url+ "/getAllRest";
        RestTemplate restTemplate = new RestTemplate();
        User[] result = restTemplate.getForObject(uri, User[].class);
        return result;*/

        return bookingRepo.getAll();

    }

    @Override
    public Booking getOneById(int id) {
        return bookingRepo.getOne(id);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepo.deleteById(id);
    }

    @Override
    public void saveBooking(Booking booking, Hotel hotel) {
        booking.setUser(booking.getUser());
        booking.setHotel(hotel);
        bookingRepo.save(booking);
    }

}