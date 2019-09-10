package com.ecommerce.app.securedapp.model.viewModels;

public class CartModelView {

    private long orderDetailsId;
    private long itemId;
    private String itemName;
    private String category;
    private int quantity;
    private double price;

    public CartModelView() {
    }

    public CartModelView(long orderDetailsId, long itemId, String itemName, String category, int quantity, double price) {
        this.orderDetailsId = orderDetailsId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    public long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
