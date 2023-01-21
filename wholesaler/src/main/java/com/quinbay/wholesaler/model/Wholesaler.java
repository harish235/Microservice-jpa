package com.quinbay.wholesaler.model;

import javax.persistence.*;

@Entity
@Table(name="wholesaler")
public class Wholesaler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name="wholesalerid")
    String wholesalerid;

    @Column(name="name")
    String wholesalername;

    @Column(name="address")
    String wholesaleraddress;

    @Column(name="phone")
    String wholesalerphone;


    public Wholesaler() {
    }

    public Wholesaler(int id, String wholesalerid, String wholesalername, String wholesaleraddress, String wholesalerphone) {
        this.id = id;
        this.wholesalerid = wholesalerid;
        this.wholesalername = wholesalername;
        this.wholesaleraddress = wholesaleraddress;
        this.wholesalerphone = wholesalerphone;
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

    public String getWholesalername() {
        return wholesalername;
    }

    public void setWholesalername(String wholesalername) {
        this.wholesalername = wholesalername;
    }

    public String getWholesaleraddress() {
        return wholesaleraddress;
    }

    public void setWholesaleraddress(String wholesaleraddress) {
        this.wholesaleraddress = wholesaleraddress;
    }

    public String getWholesalerphone() {
        return wholesalerphone;
    }

    public void setWholesalerphone(String wholesalerphone) {
        this.wholesalerphone = wholesalerphone;
    }
}
