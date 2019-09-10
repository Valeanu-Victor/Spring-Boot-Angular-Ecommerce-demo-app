package com.ecommerce.app.securedapp.model.viewModels;

public class RegisterViewModel {
    private String username;
    private String password;
    private String roles;
    private String permissions;
    private int active;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {

        return permissions;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "RegisterViewModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", permissions='" + permissions + '\'' +
                ", active=" + active +
                '}';
    }
}
