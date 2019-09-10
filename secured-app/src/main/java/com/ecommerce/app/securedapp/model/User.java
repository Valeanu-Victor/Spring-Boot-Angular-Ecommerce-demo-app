package com.ecommerce.app.securedapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    private int active;

    private String roles = "";

    private String permissions = "";

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }
}