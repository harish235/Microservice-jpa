package com.quinbay.retailer.functions;

import com.quinbay.retailer.model.Retailerstock;

import java.util.List;

public interface Retailerstockinterface {

    List<Retailerstock> getAllRetailerStock();

    String updateRetailerStock(Retailerstock rs);
}
