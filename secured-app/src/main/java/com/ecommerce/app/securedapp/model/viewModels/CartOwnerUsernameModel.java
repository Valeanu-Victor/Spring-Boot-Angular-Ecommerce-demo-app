package com.ecommerce.app.securedapp.model.viewModels;

public class CartOwnerUsernameModel {

    private String username;

    public CartOwnerUsernameModel() {
    }

    public CartOwnerUsernameModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CartOwnerUsernameModel{" +
                "username='" + username + '\'' +
                '}';
    }
}
