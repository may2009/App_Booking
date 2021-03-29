package com.example.demo.controller;

import com.example.demo.dao.BookingRepo;
import com.example.demo.dao.ClientRepo;
import com.example.demo.dao.FactureRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.Client;
import com.example.demo.models.Users;
import com.example.demo.services.UsersService;
import com.example.demo.utility.GeneratePdfFacture;
import com.itextpdf.html2pdf.HtmlConverter;
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
import java.io.File;
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
    private ClientRepo clientRepo;
    @Autowired
    private FactureRepo factureRepo;
    @Autowired
    private UsersService usersService;


   @RequestMapping("/client_facture")
    public ModelAndView client_facture() throws IOException {
        Map<String, Object> model = new HashMap<String, Object>();
        List<Client> clients = clientRepo.getAll();

           model.put("clients",clients);


           return new ModelAndView("/admin/facture", model);

    }
    @RequestMapping("/pdffacture")
    public void pdffacture() throws IOException {

        HtmlConverter.convertToPdf(new File("/admin/pdf-facture"),new File("pdf-facture.pdf"));

    }



    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {

        return  facture(16);
    }

    @RequestMapping(value = "/facture", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> facture(@RequestParam int client) throws IOException {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersService.findUserByUserName(auth.getName());

        Client clientfacture = clientRepo.getOneClient(client);


        List<Booking> bookings = bookingRepo.findAllByClientId(client);
        int sumPrix = 0;

        try {
            //  Block of code to try
            sumPrix = bookingRepo.SumPrixBooking(client);
        }
        catch(Exception e) {
            //  Block of code to handle errors
            sumPrix = 0;
        }



        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=facture.pdf");



        ByteArrayInputStream bis = GeneratePdfFacture.bookingfacture(bookings,clientfacture,sumPrix);



        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));


    }

}