package com.ecommerce.app.securedapp.model.viewModels;

public class RemoveOneProductModel {

    private long idOrderDetails;
    private String username;

    public RemoveOneProductModel() {
    }

    public RemoveOneProductModel(long idOrderDetails, String username) {
        this.idOrderDetails = idOrderDetails;
        this.username = username;
    }

    public long getIdOrderDetails() {
        return idOrderDetails;
    }

    public void setIdOrderDetails(long idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
