package com.ecommerce.app.securedapp.dto;

import com.ecommerce.app.securedapp.model.User;

import java.util.Date;

public class OrdersDto {

    private long id_order;
    private User user;
    private double totalCost;
    private Date createdDate;
    private boolean isCheckedOut;

    public OrdersDto() {
    }

    public OrdersDto(User user, double totalCost, Date createdDate, boolean isCheckedOut) {
        this.user = user;
        this.totalCost = totalCost;
        this.createdDate = createdDate;
        this.isCheckedOut = isCheckedOut;
    }

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
}