package com.quinbay.wholesaler.functions;

import com.quinbay.wholesaler.model.Wholesaler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Wholesalerinterface {

    List<Wholesaler> getAllWholesaler();

    ResponseEntity<Wholesaler> getWholesaler(int w_id);

    String createWholesaler(Wholesaler w);

    ResponseEntity<HttpStatus> deleteWholesaler(int id);
}
