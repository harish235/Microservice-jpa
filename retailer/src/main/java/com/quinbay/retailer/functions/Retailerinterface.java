package com.quinbay.retailer.functions;

import com.quinbay.retailer.model.Retailer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Retailerinterface {

    List<Retailer> getAllRetailer();

    ResponseEntity<Retailer> getRetailer(int r_id);

    String createRetailer(Retailer r);

    ResponseEntity<HttpStatus> deleteRetailer(int id);
}
