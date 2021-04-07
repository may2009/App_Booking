package com.example.demo.api;
import com.example.demo.dao.BookingRepo;
import com.example.demo.dao.ClientRepo;
import com.example.demo.dao.HotelRepo;
import com.example.demo.dao.RoomRepo;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*@CrossOrigin(origins = "http://localhost:8081")*/
@RestController
@RequestMapping("/api")
public class HomeApi {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    HotelRepo hotelRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    private ClientService clientServices;
    @GetMapping(value = "/getAllCard")
    public Map<String, Object> getAll(){

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("clients",clientRepo.findAll().size());
        model.put("hotels",hotelRepo.findAll().size());
        model.put("chambres",roomRepo.findAll().size());
        model.put("bookings",bookingRepo.findAll().size());

        return model;
    }

}