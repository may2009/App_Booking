package com.example.demo.utility;

import com.example.demo.dao.BookingRepo;
import com.example.demo.models.Booking;
import com.example.demo.models.Client;
import com.example.demo.models.Users;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import org.springframework.beans.factory.annotation.Autowired;
import com.itextpdf.layout.element.Table;


import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratePdfFacture {
    @Autowired
    private BookingRepo bookingRepo;


/*
    private static String FILE = "C:/Users/TNC 2021/Desktop/JAVA PROJET/App_Booking/FirstPdf.pdf";
*/

    public static ByteArrayInputStream bookingfacture(List<Booking> bookings, Client client, float sumPrix,String FILE) throws FileNotFoundException, DocumentException {


        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));

/*
        document.addTitle("Facture : "+user.getUserName());*/

        try {



            float fntSize, lineSpacing;
            fntSize = 18.7f;
            lineSpacing = 20f;

            Font headParag = FontFactory.getFont(FontFactory.HELVETICA_BOLD,fntSize);

            Font font = new Font(Font.FontFamily.TIMES_ROMAN,20,Font.BOLD);

            Paragraph paragraph1 = new Paragraph( new Phrase("Facture : "+client.getName()+" "+client.getLastName(),font));
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            paragraph1.setPaddingTop(0);
           /* paragraph1.add(Chunk.NEWLINE);*/
            paragraph1.setFont(font);
            paragraph1.setSpacingAfter(12);






            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new int[] { 5, 5, 5, 5 });
            table.getDefaultCell().setBorderWidth(0f);

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




            //Total
            PdfPTable total = new PdfPTable(1);
            total.setSpacingBefore(20);
            total.setWidthPercentage(25);
            total.setHorizontalAlignment(Element.ALIGN_RIGHT);


            Font totalFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcelltotal;
            hcelltotal = new PdfPCell(new Phrase("Total", headFont));
            hcelltotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            total.addCell(hcelltotal);


            PdfPCell celltotal;
            celltotal = new PdfPCell(new Phrase(sumPrix+" MAD"));
            celltotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            celltotal.setBackgroundColor(BaseColor.RED);
            total.addCell(celltotal);




            PdfWriter.getInstance(document, out);
            document.open();




            //images
            Image img = Image.getInstance("logo.png");
           /* img.setRotation(270f);*/
            img.scaleAbsolute(100f, 50f);


            document.add(img);
            document.add(paragraph1);
            document.add(table);
            document.add(total);

            document.close();



        } catch (DocumentException | FileNotFoundException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());

    }
}
