package com.quinbay.invoicegeneration.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.quinbay.invoicegeneration.model.EmailDetails;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class Invoiceservice {

    @Autowired
    private Emailservice emailService;

    public void generateBill(String clienttype, String clientId, String clientName , String retailerid, String retailername, String productid, String productname, int price, int quantity, int discountPercentage, float gstPercent) throws IOException {

        int billAmount, grandBillAmount;
        float gstAmount;
        try {
            Document my_pdf_report = new Document();

            UUID randomUid = UUID.randomUUID();

            String file_loc = "/Users/harish/Downloads/Microservice_jpa/invoicegeneration/"+clientName+"_"+randomUid.toString()+".pdf";
            System.out.println("\n reached - 1");
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream(file_loc));
            System.out.println("\n reached - 2");
            my_pdf_report.open();
            Paragraph para = new Paragraph();
            PdfPTable my_report_table = new PdfPTable(2);
            PdfPCell table_cell;
            my_report_table.setSpacingAfter(10);
            my_report_table.setSpacingBefore(4);
            my_report_table.getRowHeight(10);

            table_cell = new PdfPCell(new Phrase("CLIENT TYPE :"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(clienttype));
            my_report_table.addCell(table_cell);

            table_cell = new PdfPCell(new Phrase("CLIENT ID :"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(clientId));
            my_report_table.addCell(table_cell);


            table_cell = new PdfPCell(new Phrase("CLIENT NAME:"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(clientName));
            my_report_table.addCell(table_cell);

            table_cell = new PdfPCell(new Phrase("RETAILER ID :"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(retailerid));
            my_report_table.addCell(table_cell);


            table_cell = new PdfPCell(new Phrase("RETAILER NAME:"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(retailername));
            my_report_table.addCell(table_cell);


            table_cell = new PdfPCell(new Phrase("PRODUCT ID:"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(productid));
            my_report_table.addCell(table_cell);


            table_cell = new PdfPCell(new Phrase("PRODUCT NAME:"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(productname));
            my_report_table.addCell(table_cell);

            table_cell = new PdfPCell(new Phrase("QUANTITY"));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(Integer.toString(quantity)));
            my_report_table.addCell(table_cell);


            billAmount = quantity * price;
            table_cell = new PdfPCell(new Phrase("PRICE PER UNIT "));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(Integer.toString(price)));
            my_report_table.addCell(table_cell);

            billAmount = quantity * price;
            table_cell = new PdfPCell(new Phrase("BILL AMOUNT "));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(Integer.toString(billAmount)));
            my_report_table.addCell(table_cell);


            table_cell = new PdfPCell(new Phrase("DISCOUNT PERCENTAGE "));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(Integer.toString(discountPercentage) + "%"));
            my_report_table.addCell(table_cell);

            table_cell = new PdfPCell(new Phrase("GST PERCENTAGE: "));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(gstPercent+"%"));
            my_report_table.addCell(table_cell);

            gstAmount = (billAmount * gstPercent)/100;
            table_cell = new PdfPCell(new Phrase("GST AMOUNT: "));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(Float.toString(gstAmount)));
            my_report_table.addCell(table_cell);

            grandBillAmount = billAmount + (int)gstAmount;
            System.out.println("\n\tBuying price of the product: "+ grandBillAmount);

            table_cell = new PdfPCell(new Phrase("Grand Total Amount: "));
            my_report_table.addCell(table_cell);
            table_cell = new PdfPCell(new Phrase(Float.toString(grandBillAmount)));
            my_report_table.addCell(table_cell);


            my_pdf_report.add(my_report_table);
            System.out.println("\n\tBill generated!!!________------------___________");

            EmailDetails ed = new EmailDetails();
            ed.setRecipient("kowreesh3801@gmail.com");
            ed.setSubject("intern task");
            ed.setMsgBody("Hello \n\n welocme to gmail!!!");
            ed.setAttachment(file_loc);

            emailService.sendMailWithAttachment(ed);

            my_pdf_report.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
