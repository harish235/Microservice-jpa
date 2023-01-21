package com.quinbay.wholesaler.functions;

import com.quinbay.wholesaler.model.Wholesaler;
import com.quinbay.wholesaler.model.Wholesalerstock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Wholesalerstockinterface {

    String updateWholesalerStock(Wholesalerstock ws);

    List<Wholesalerstock> getAllWholesalerStock();

}
