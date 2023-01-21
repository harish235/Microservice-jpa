package com.quinbay.retailer.model;


import javax.persistence.*;

@Entity
@Table(name = "retailer")
public class Retailer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="retailerid")
    String retailerid;

    @Column(name="name")
    String retailername;

    @Column(name="address")
    String retaileraddress;

    @Column(name="phone")
    String retailerphone;


    public Retailer() {
    }

    public Retailer(int id, String retailerid, String retailername, String retaileraddress, String retailerphone) {
        this.id = id;
        this.retailerid = retailerid;
        this.retailername = retailername;
        this.retaileraddress = retaileraddress;
        this.retailerphone = retailerphone;
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

    public String getRetailername() {
        return retailername;
    }

    public void setRetailername(String retailername) {
        this.retailername = retailername;
    }

    public String getRetaileraddress() {
        return retaileraddress;
    }

    public void setRetaileraddress(String retaileraddress) {
        this.retaileraddress = retaileraddress;
    }

    public String getRetailerphone() {
        return retailerphone;
    }

    public void setRetailerphone(String retailerphone) {
        this.retailerphone = retailerphone;
    }
}
