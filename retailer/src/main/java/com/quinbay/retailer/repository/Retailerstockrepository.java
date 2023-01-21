package com.quinbay.retailer.repository;


import com.quinbay.retailer.model.Retailer;
import com.quinbay.retailer.model.Retailerstock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Retailerstockrepository extends JpaRepository<Retailerstock, Integer> {

//    Retailerstock

    Retailerstock findByRetaileridAndProductidAndWholesalerid(String r_id, String p_id, String w_id);
}
