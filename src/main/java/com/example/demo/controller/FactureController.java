package com.example.demo.controller;

import com.example.demo.dao.BookingRepo;
import com.example.demo.dao.ClientRepo;
import com.example.demo.dao.FactureRepo;
import com.example.demo.dao.SendMailRepo;
import com.example.demo.models.*;
import com.example.demo.services.UsersService;
import com.example.demo.utility.GeneratePdfFacture;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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


    @Value("${gmail.username}")
    private String username;
    @Value("${gmail.password}")
    private String password;
    @Autowired
    SendMailRepo sendMailRepo;


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
    public ResponseEntity<InputStreamResource> download() throws IOException, javax.mail.MessagingException, DocumentException {

        return  facture(16);
    }

    @RequestMapping(value = "/facture", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> facture(@RequestParam int client) throws IOException, javax.mail.MessagingException, DocumentException {


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


/*
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=facture.pdf");*/



        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date date = new Date();

        String filePath = new File("").getAbsolutePath();
        String path = filePath.replaceAll("\\\\", "/");
        String FILE = path+"/pdf-file/" + clientfacture.getName()+"_" + dateFormat.format(date) +".pdf";

        ByteArrayInputStream bis = GeneratePdfFacture.bookingfacture(bookings,clientfacture,sumPrix,FILE);

/*
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd-HH");
        Date date2 = new Date();
        Facture facture = new Facture();
        facture.setName(clientfacture.getName()+"_" + dateFormat.format(date) +".pdf");
        facture.setDatefacture(dateFormat2.format(date2) );
        facture.setClient(clientfacture);
        factureRepo.save(facture);*/


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");


        sendmail(clientfacture,FILE);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));



    }


    private @ResponseBody void sendmail(Client client,String file) throws AddressException, MessagingException, IOException, javax.mail.MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });



        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("skimohp@gmail.com"));
        msg.setSubject("sujett");
        msg.setContent("message" ,"text/html");
        msg.setSentDate(new Date());




        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("messageee", "text/html");


        //Facture facture = factureRepo.getByClient(client.getId());


        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile(file);
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);


        // sends the e-mail
        Transport.send(msg);

    }




}