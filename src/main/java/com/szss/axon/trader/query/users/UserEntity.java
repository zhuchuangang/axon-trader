package com.szss.axon.trader.query.users;

import org.springframework.data.annotation.Id;

/**
 * Created by zcg on 15/9/18.
 */
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String username;
    private String password;

    public UserEntity() {
    }

    public UserEntity(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
