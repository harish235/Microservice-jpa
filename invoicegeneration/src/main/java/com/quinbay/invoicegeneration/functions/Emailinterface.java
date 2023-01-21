package com.quinbay.invoicegeneration.functions;

import com.quinbay.invoicegeneration.model.EmailDetails;

// Interface
public interface Emailinterface {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}