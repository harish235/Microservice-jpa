package com.quinbay.wholesaler.controller;


import com.quinbay.wholesaler.functions.Wholesalerinterface;
import com.quinbay.wholesaler.functions.Wholesalerstockinterface;
import com.quinbay.wholesaler.model.Wholesaler;
import com.quinbay.wholesaler.model.Wholesalerstock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Maincontroller {

    @Autowired
    Wholesalerinterface wholesalerinterface;

    @Autowired
    Wholesalerstockinterface wholesalerstockinterface;

    @GetMapping("/wholesaler")
    public List<Wholesaler> getAllWholesaler(){
        return wholesalerinterface.getAllWholesaler();
    }

    @GetMapping("/wholesaler/{id}")
    public ResponseEntity<Wholesaler> getWholesalerById(@PathVariable(value="id") Integer wholesalerid){
        return wholesalerinterface.getWholesaler(wholesalerid);
    }

    @PostMapping("/createWholesaler")
    public String createWholesaler(@RequestBody Wholesaler w){
        return wholesalerinterface.createWholesaler(w);
    }

    @DeleteMapping("/deleteWholesaler")
    public ResponseEntity<HttpStatus> deleteWholesaler(@RequestParam int w_id){
        return wholesalerinterface.deleteWholesaler(w_id);
    }

    @PutMapping("/updateWholesalerStock")
    public String updateWholesalerStock(@RequestBody Wholesalerstock w){
        return wholesalerstockinterface.updateWholesalerStock(w);
    }

    @GetMapping("/wholesalerstock")
    public List<Wholesalerstock> getAllWholesalerStock(){
        return wholesalerstockinterface.getAllWholesalerStock();
    }
}
