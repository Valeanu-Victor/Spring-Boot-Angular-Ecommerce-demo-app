package com.ecommerce.app.securedapp.dto;

import com.ecommerce.app.securedapp.model.Item;
import com.ecommerce.app.securedapp.model.Orders;

public class OrderDetailsDto {

    private long id;
    private Orders orders;
    private Item item;
    private int quantity;
    private double price;
    private double amount;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(Orders orders, Item item, int quantity, double price, double amount) {
        this.orders = orders;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
