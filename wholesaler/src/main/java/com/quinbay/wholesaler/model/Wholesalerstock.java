package com.quinbay.wholesaler.model;

import javax.persistence.*;


@Entity
@Table(name="wholesalerstock")
public class Wholesalerstock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="wholesalerid")
    String wholesalerid;

    @Column(name ="warehouseid")
    String warehouseid;

    @Column(name="productid")
    String productid;

    @Column(name="price")
    int productprice;

    @Column(name="stock")
    int stock;

    public Wholesalerstock() {
    }

    public Wholesalerstock(int id, String wholesalerid, String warehouseid, String productid, int productprice, int stock) {
        this.id = id;
        this.wholesalerid = wholesalerid;
        this.warehouseid = warehouseid;
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

    public String getWholesalerid() {
        return wholesalerid;
    }

    public void setWholesalerid(String wholesalerid) {
        this.wholesalerid = wholesalerid;
    }

    public String getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(String warehouseid) {
        this.warehouseid = warehouseid;
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
