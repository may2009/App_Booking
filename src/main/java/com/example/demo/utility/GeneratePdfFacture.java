package com.example.demo.utility;

import com.example.demo.dao.BookingRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.Users;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfFacture {
    @Autowired
    private BookingRepo bookingRepo;



    public static ByteArrayInputStream bookingfacture(List<Booking> bookings, Users user) {


        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

/*
        document.addTitle("Facture : "+user.getUserName());*/

        try {
/*
            Paragraph paragraph1 = new Paragraph();
            paragraph1.add("Facture : "+user.getUserName(),Element.ALIGN_LEFT);*/




            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new int[] { 5, 5, 5, 5 });

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Name", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Hotel", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Prix", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);





            for (Booking bk : bookings) {

                PdfPCell cell;

                if(bk.getTitre() != null) {
                    cell = new PdfPCell(new Phrase(bk.getTitre()));

                }else{
                    cell = new PdfPCell(new Phrase(""));
                }
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                if(bk.getHotel() != null) {
                    cell = new PdfPCell(new Phrase(bk.getHotel().getName()));

                }else{
                    cell = new PdfPCell(new Phrase(""));
                }
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);



                if(bk.getPrix() != null) {
                    cell = new PdfPCell(new Phrase(String.valueOf(bk.getPrix())));

                }else{
                    cell = new PdfPCell(new Phrase(""));
                }

                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);



                if(bk.getBooking_time() != null) {
                    cell = new PdfPCell(new Phrase(String.valueOf(bk.getBooking_time())));

                }else{
                    cell = new PdfPCell(new Phrase(""));
                }

                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);



            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.addTitle("Facture : " + user.getUserName());
           /* document.add(paragraph1);*/
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ByteArrayInputStream(out.toByteArray());

    }
}
