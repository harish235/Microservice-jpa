package com.quinbay.wholesaler.service;


import com.quinbay.wholesaler.functions.Wholesalerinterface;
import com.quinbay.wholesaler.functions.Wholesalerstockinterface;
import com.quinbay.wholesaler.kafka.KafkaPublisherService;
import com.quinbay.wholesaler.model.Invoicedetails;
import com.quinbay.wholesaler.model.Wholesalerstock;
import com.quinbay.wholesaler.repository.Wholesalerstockrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Wholesalerstockservice implements Wholesalerstockinterface {

    @Autowired
    Wholesalerstockrepository wsr;

    @Override
    public List<Wholesalerstock> getAllWholesalerStock(){
        return wsr.findAll();
    }

    @Autowired
    KafkaPublisherService kafkaPublisherService;

    @Override
    public String updateWholesalerStock(Wholesalerstock w){
        Wholesalerstock newStock = wsr.findByWholesaleridAndWarehouseidAndProductid(w.getWholesalerid(), w.getWarehouseid(), w.getProductid());
        Invoicedetails invoice = null;
        if(newStock != null){
            newStock.setProductprice(w.getProductprice());
            newStock.setStock(w.getStock());
            wsr.save(newStock);
            invoice = new Invoicedetails("wholesaler", w.getWholesalerid(), "harish", w.getWarehouseid(), "sundar", w.getProductid(), "phone", w.getProductprice(), w.getStock(), 10, 18);
            kafkaPublisherService.sendWholesalerForBilling(invoice);

        }
        else{
            newStock = new Wholesalerstock();
            newStock.setWarehouseid(w.getWarehouseid());
            newStock.setWholesalerid(w.getWholesalerid());
            newStock.setProductid(w.getProductid());
            newStock.setStock(w.getStock());
            newStock.setProductprice(w.getProductprice());
            newStock.setId(w.getId());

            wsr.save(newStock);
            invoice = new Invoicedetails("wholesaler", w.getWholesalerid(), "harish", w.getWarehouseid(), "sundar", w.getProductid(), "phone", w.getProductprice(), w.getStock(), 10, 18);
            kafkaPublisherService.sendWholesalerForBilling(invoice);
        }
        return "Retailer stock updated!!!";
    }


//    @Override
//    public String updateWholesalerStock(Wholesalerstock w){
//        Wholesalerstock newStock = wsr.findByWholesaleridandProductid(w.getWholesalerid(), w.getProductid());
//
//        if(newStock != null) {
//            newStock.setProductprice(w.getProductprice());
//            newStock.setStock(w.getStock());
//            wsr.save(newStock);
//        }
//        else{
//            newStock = new Wholesalerstock();
//            newStock.setWarehouseid(w.getWarehouseid());
//            newStock.setWholesalerid(w.getWholesalerid());
//            newStock.setProductid(w.getProductid());
//            newStock.setProductprice(w.getProductprice());
//            newStock.setStock(w.getStock());
//            wsr.save(newStock);
//        }
//        return "Wholesaler stock updated!!!";
//    }

}
