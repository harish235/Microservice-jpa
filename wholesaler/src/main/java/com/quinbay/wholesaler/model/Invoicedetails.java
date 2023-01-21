package com.quinbay.wholesaler.model;

public class Invoicedetails {
    String clienttype;
    String clientid;
    String clientname;
    String retailerid;
    String retailername;
    String productid;
    String productname;
    int price;
    int quantity;
    int discount;
    float gstpercent;

    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
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

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public float getGstpercent() {
        return gstpercent;
    }

    public void setGstpercent(float gstpercent) {
        this.gstpercent = gstpercent;
    }

    public Invoicedetails() {
    }

    public Invoicedetails(String clienttype, String clientid, String clientname, String retailerid, String retailername, String productid, String productname, int price, int quantity, int discount, float gstpercent) {
        this.clienttype = clienttype;
        this.clientid = clientid;
        this.clientname = clientname;
        this.retailerid = retailerid;
        this.retailername = retailername;
        this.productid = productid;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.gstpercent = gstpercent;
    }
}
