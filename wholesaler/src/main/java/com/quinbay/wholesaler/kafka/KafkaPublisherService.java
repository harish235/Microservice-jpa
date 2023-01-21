package com.quinbay.wholesaler.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quinbay.wholesaler.model.Invoicedetails;
import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaPublisherService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void wholeSalerInformation(Wholesaler wholesaler){

        try {
            kafkaTemplate.send("send.wholesalerinfo", this.objectMapper.writeValueAsString(wholesaler));
        }catch (Exception e){
            System.out.println("error is publishing "+e);
        }

    }


    public void sendWholesalerList(List<Wholesaler> wlist){
        try{
            kafkaTemplate.send("send.wholesalers", this.objectMapper.writeValueAsString(wlist));
        } catch(Exception e){
            System.out.println("error is publishing "+e);
        }
    }

    public void sendWholesalerForBilling(Invoicedetails inv){
        try{
            kafkaTemplate.send("send.wholesalerbilling", this.objectMapper.writeValueAsString(inv));
        }catch(Exception e){
            System.out.println("error is building "+ e);
        }
    }
}
