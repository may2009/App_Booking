package com.example.demo.api;


import com.example.demo.dao.SendMailRepo;
import com.example.demo.models.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessagingException;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;


@RestController
@RequestMapping("/api")
public class SendMailApi {
/*

    @Value("${gmail.username}")
    private String username;
    @Value("${gmail.password}")
    private String password;
    @Autowired
    SendMailRepo sendMailRepo;

    @RequestMapping(value="/send", method= RequestMethod.POST)
    public List<SendMail> sendEmail(@RequestBody SendMail sendmail) throws javax.mail.MessagingException, MessagingException, IOException {
        sendmail(sendmail);

        sendMailRepo.save(sendmail);
        return sendMailRepo.findAll();
    }


    private void sendmail(SendMail sendMail) throws AddressException, MessagingException, IOException, javax.mail.MessagingException {

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

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendMail.getToemail()));
        msg.setSubject(sendMail.getSubject());
        msg.setContent(sendMail.getMessage(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(sendMail.getMessage(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
  MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("C:\\talk2amareswaran-downloads\\mysql2.png");
        multipart.addBodyPart(attachPart);


        msg.setContent(multipart);


        // sends the e-mail
        Transport.send(msg);

    }
*/


}
