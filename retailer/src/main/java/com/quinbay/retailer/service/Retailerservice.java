package com.quinbay.retailer.service;


import com.quinbay.retailer.functions.Retailerinterface;
import com.quinbay.retailer.model.Retailer;
import com.quinbay.retailer.repository.Retailerrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Retailerservice implements Retailerinterface {

    @Autowired
    Retailerrepository retailerrepository;

    @Override
    public List<Retailer> getAllRetailer(){
        return retailerrepository.findAll();
    }

    @Override
    public ResponseEntity<Retailer> getRetailer(int r_id){
        Optional<Retailer> retailerData = retailerrepository.findById(r_id);
        if(retailerData.isPresent()){
            return new ResponseEntity<>(retailerData.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public String createRetailer(Retailer r){
        try{
            Retailer _r = retailerrepository.save(r);
            return "Retailer created successfully!!!";
        }catch(Exception e){
            return "Retailer cannot be created!!!";
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteRetailer(int r_id){
        try{
            retailerrepository.deleteById(r_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
