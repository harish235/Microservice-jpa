package com.quinbay.invoicegeneration;

import com.quinbay.invoicegeneration.service.Invoiceservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InvoicegenerationApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(InvoicegenerationApplication.class, args);

//		Invoiceservice inv = new Invoiceservice();
//		inv.generateBill(1, "harish", "p01", "phone", 12000, 10, 10, 18);
	}

}
