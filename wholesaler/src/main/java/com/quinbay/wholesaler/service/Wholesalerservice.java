package com.quinbay.wholesaler.service;


import com.quinbay.wholesaler.functions.Wholesalerinterface;
import com.quinbay.wholesaler.kafka.KafkaPublisherService;
import com.quinbay.wholesaler.model.Wholesaler;
import com.quinbay.wholesaler.repository.Wholesalerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Wholesalerservice implements Wholesalerinterface {

    @Autowired
    Wholesalerrepository wholesalerrepository;

    @Autowired
    KafkaPublisherService kafkaPublisherService;

    @Override
    public List<Wholesaler> getAllWholesaler(){
        List<Wholesaler> wholesalers = wholesalerrepository.findAll();
        kafkaPublisherService.sendWholesalerList(wholesalers);
        return wholesalerrepository.findAll();
    }

    @Override
    public ResponseEntity<Wholesaler> getWholesaler(int w_id){
        Optional<Wholesaler> wholesalerdata = wholesalerrepository.findById(w_id);
        kafkaPublisherService.wholeSalerInformation(wholesalerdata.get());
        if(wholesalerdata.isPresent()){
            return new ResponseEntity<>(wholesalerdata.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String createWholesaler(Wholesaler w){
        try{
            Wholesaler _w = wholesalerrepository.save(w);
            return "Wholesaler created successfully!!!";
        } catch(Exception e){
            return "Wholesaler cannot be created!!!";
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteWholesaler(int w_id){
        try{
            wholesalerrepository.deleteById(w_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
