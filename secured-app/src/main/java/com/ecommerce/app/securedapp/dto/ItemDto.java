package com.ecommerce.app.securedapp.dto;

import java.util.Date;

public class ItemDto {

    private long id;
    private String category;
    private String name;
    private int quantity;
    private double price;
    private Date createdDate;

    public ItemDto(String category, String name, int quantity, double price, Date createdDate) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.createdDate = createdDate;
    }

    public ItemDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
