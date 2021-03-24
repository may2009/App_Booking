package com.example.demo.controller;

import com.example.demo.dao.BookingRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.Users;
import com.example.demo.services.UsersService;
import com.example.demo.utility.GeneratePdfFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class FactureController {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private UsersService usersService;


/*   @RequestMapping("/facture")
    public ModelAndView welcome() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<Booking> bookings = bookingRepo.getAll();

           model.put("booking",bookings);

           return new ModelAndView("/admin/facture", model);

    }*/

    @RequestMapping(value = "/facture", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> facture() throws IOException {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersService.findUserByUserName(auth.getName());


        List<Booking> bookings = bookingRepo.findAllByUserId(user);

        ByteArrayInputStream bis = GeneratePdfFacture.bookingfacture(bookings,user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=facture.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}