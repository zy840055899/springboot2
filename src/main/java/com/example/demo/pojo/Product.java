package com.example.demo.pojo;

import java.io.Serializable;

public class Product implements Serializable {

    private long id;
    private String productName;
    private long stock;
    private double price;
    private long version;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
