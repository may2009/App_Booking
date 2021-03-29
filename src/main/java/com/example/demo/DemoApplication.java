package com.example.demo;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);
/*
        HtmlConverter.convertToPdf(new File("./pdf-facture.jsp"),new File("pdf-facture.pdf"));
*/

    }


}

