package com.ecommerce.app.securedapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "id_order")
    private long idOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "orders_user_FK"))
    private User user;

    @Column(name = "total_cost")
    private double totalCost;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "is_checked_out")
    private boolean isCheckedOut;

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
}