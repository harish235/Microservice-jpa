package com.quinbay.retailer.service;

import com.quinbay.retailer.functions.Retailerinterface;
import com.quinbay.retailer.functions.Retailerstockinterface;
import com.quinbay.retailer.model.Retailerstock;
import com.quinbay.retailer.repository.Retailerrepository;
import com.quinbay.retailer.repository.Retailerstockrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Retailerstockservice implements Retailerstockinterface {

    @Autowired
    Retailerstockrepository rsr;

    @Override
    public List<Retailerstock> getAllRetailerStock(){
        return rsr.findAll();
    }

    @Override
    public String updateRetailerStock(Retailerstock r){
        Retailerstock newStock = rsr.findByRetaileridAndProductidAndWholesalerid(r.getRetailerid(), r.getProductid(), r.getWholesalerid());

        if(newStock != null){
            newStock.setProductprice(r.getProductprice());
            newStock.setStock(r.getStock());
            rsr.save(newStock);
        }
        else{
            newStock = new Retailerstock();
            newStock.setRetailerid(r.getRetailerid());
            newStock.setWholesalerid(r.getWholesalerid());
            newStock.setProductid(r.getProductid());
            newStock.setStock(r.getStock());
            newStock.setProductprice(r.getProductprice());
            newStock.setId(r.getId());

            rsr.save(newStock);
        }
        return "Retailer stock updated!!!";
    }
}
