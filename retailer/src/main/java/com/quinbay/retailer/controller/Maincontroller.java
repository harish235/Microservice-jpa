package com.quinbay.retailer.controller;


import com.quinbay.retailer.functions.Retailerinterface;
import com.quinbay.retailer.functions.Retailerstockinterface;
import com.quinbay.retailer.model.Retailer;
import com.quinbay.retailer.model.Retailerstock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Maincontroller {

    @Autowired
    Retailerinterface retailerinterface;

    @Autowired
    Retailerstockinterface retailerstockinterface;


    @GetMapping("/retailer")
    public List<Retailer> getAllRetailer(){
        return retailerinterface.getAllRetailer();
    }

    @GetMapping("/retailer/{id}")
    public ResponseEntity<Retailer> getRetailerById(@PathVariable(value="id") Integer retailerid){
        return retailerinterface.getRetailer(retailerid);
    }

    @PostMapping("/createRetailer")
    public String createRetailer(@RequestBody Retailer r){
        return retailerinterface.createRetailer(r);
    }

    @DeleteMapping("/deleteRetailer")
    public ResponseEntity<HttpStatus> deleteRetailer(@RequestParam int r_id){
        return retailerinterface.deleteRetailer(r_id);
    }

    @GetMapping("/retailerstock")
    public List<Retailerstock> getAllRetailerStock(){
        return retailerstockinterface.getAllRetailerStock();
    }

    @PutMapping("/updateRetailerStock")
    public String updateRetailerStock(@RequestBody Retailerstock r){
        return retailerstockinterface.updateRetailerStock(r);
    }

}
