package com.example.demo.services;

import com.example.demo.models.Booking;
import com.example.demo.models.Hotel;
import com.example.demo.models.User;

import java.util.List;

public interface BookingService {
    public List<Booking> getAllBooking();
    public Booking getOneById(int id);
    public void deleteBooking(int id);
    void saveBooking(Booking booking, Hotel hotel);
}