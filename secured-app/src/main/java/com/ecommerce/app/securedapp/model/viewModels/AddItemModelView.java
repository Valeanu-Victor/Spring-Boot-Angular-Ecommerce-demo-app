package com.ecommerce.app.securedapp.model.viewModels;

public class AddItemModelView {

    private String username;
    private long idItem;
    private int quantity;
    private double price;

    public AddItemModelView(String username, long idItem, int quantity, double price) {
        this.username = username;
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
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

    @Override
    public String toString() {
        return "AddItemModelView{" +
                "username='" + username + '\'' +
                ", idItem=" + idItem +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
