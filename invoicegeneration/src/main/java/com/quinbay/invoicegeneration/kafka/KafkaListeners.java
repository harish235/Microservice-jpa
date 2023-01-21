package com.quinbay.invoicegeneration.kafka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.invoicegeneration.model.Invoicedetails;
import com.quinbay.invoicegeneration.service.Invoiceservice;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaListeners {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Invoiceservice invoiceservice;

    @KafkaListener(topics = "send.wholesalerbilling",groupId = "warehouse")
    public void getInvoiceForBilling(ConsumerRecord<?,String> consumerRecord){
        Invoicedetails inv = null;
        try {
            inv = objectMapper.readValue(consumerRecord.value(),
                    new TypeReference<Invoicedetails>() {
                    });

            System.out.println(inv.getClientname()+"  "+ inv.getProductname());
            invoiceservice.generateBill(inv.getClienttype(), inv.getClientid(), inv.getClientname(), inv.getRetailerid(), inv.getRetailername(), inv.getProductid(), inv.getProductname(),inv.getPrice(), inv.getQuantity(), inv.getDiscount(),inv.getGstpercent());

        }catch (Exception e){

        }

    }
}