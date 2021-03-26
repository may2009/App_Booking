package com.example.demo.controller;

import com.example.demo.dao.*;
import com.example.demo.models.Booking;
import com.example.demo.models.Client;
import com.example.demo.models.Hotel;
import com.example.demo.models.Permission;
import com.example.demo.services.BookingService;
import com.example.demo.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private PermissionRepo permissionRepo;

    @RequestMapping("/addBooking")
    public ModelAndView addBooking() {
        Map<String, Object> model = new HashMap<String, Object>();

        List<Client> clients = clientRepo.getClientByAge();
        model.put("clients",clients);
        model.put("hotel",hotelRepo.findAll());
        model.put("submit","Ajouter");
        return new ModelAndView("admin/booking", model);
    }

    @PostMapping(value="/saveBooking")
    public ModelAndView add(@ModelAttribute Hotel hotel, @ModelAttribute Booking booking) throws JsonProcessingException {

        bookingService.saveBooking(booking,hotel);

        return listBooking();
    }

    @RequestMapping("/listBooking")
    public ModelAndView listBooking() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<Booking> booking = bookingService.getAllBooking();
        model.put("booking",booking);
        model.put("page",2);
        return new ModelAndView("admin/listBooking", model);
    }
    @GetMapping("/editBooking")
    public ModelAndView editBooking(@RequestParam int id) {
        Map<String, Object> model = new HashMap<String, Object>();
        Booking booking = bookingService.getOneById(id);
        List<Client> clients = clientService.getAll();
        model.put("booking",booking);
        model.put("clients",clients);
        model.put("submit","Modifier");
        return new ModelAndView("admin/booking", model);
    }

@GetMapping("/deleteBooking")
    public String deleteBooking(@RequestParam int id) {
        Map<String, Object> model = new HashMap<String, Object>();
        Booking booking = bookingService.getOneById(id);

        bookingService.deleteBooking(id);

    return "redirect:/admin/listBooking";
    }



    @RequestMapping("/calendar")
    public ModelAndView calendar() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<Booking> bookings = bookingRepo.getAll();


        model.put("bookings",bookings);
        Permission permission = permissionRepo.findByPageId(4);
        model.put("permission",permission);
        if(!permission.getAfficher().equals("1")){
            return new ModelAndView("/error", model);
        }else {
            return new ModelAndView("/admin/calendar", model);
        }
    }


    @RequestMapping(value="/all_bookings", method = RequestMethod.GET)
    public @ResponseBody List<Booking> all_bookings() throws
            JsonProcessingException {
        List<Booking> booking = bookingRepo.findAll();

        return booking;
    }


}