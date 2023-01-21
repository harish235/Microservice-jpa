package com.quinbay.retailer.model;


import javax.persistence.*;

@Entity
@Table(name="retailerstock")
public class Retailerstock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="retailerid")
    String retailerid;

    @Column(name="wholesalerid")
    String wholesalerid;

    @Column(name = "productid")
    String productid;

    @Column(name = "price")
    int productprice;

    @Column(name = "stock")
    int stock;

    public Retailerstock() {
    }

    public Retailerstock(int id, String retailerid, String wholesalerid, String productid, int productprice, int stock) {
        this.id = id;
        this.retailerid = retailerid;
        this.wholesalerid = wholesalerid;
        this.productid = productid;
        this.productprice = productprice;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRetailerid() {
        return retailerid;
    }

    public void setRetailerid(String retailerid) {
        this.retailerid = retailerid;
    }

    public String getWholesalerid() {
        return wholesalerid;
    }

    public void setWholesalerid(String wholesalerid) {
        this.wholesalerid = wholesalerid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
