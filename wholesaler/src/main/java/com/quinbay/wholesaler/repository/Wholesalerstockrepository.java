package com.quinbay.wholesaler.repository;


import com.quinbay.wholesaler.model.Wholesalerstock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Wholesalerstockrepository extends JpaRepository<Wholesalerstock, Integer> {

//    Wholesalerstock findByWholesaleridandProductid(String w_id, String p_id);

    Wholesalerstock findByWholesaleridAndWarehouseidAndProductid(String wh_id, String w_id, String p_id);
}
