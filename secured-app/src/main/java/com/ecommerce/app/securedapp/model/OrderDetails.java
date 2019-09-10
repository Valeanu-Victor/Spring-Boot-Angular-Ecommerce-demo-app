package com.ecommerce.app.securedapp.model;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue
    @Column(name = "id_order_details")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order", foreignKey = @ForeignKey(name = "order_details_order_FK"))
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_item", foreignKey = @ForeignKey(name = "order_details_item_FK"))
    private Item item;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "amount")
    private double amount;

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
