package com.szss.axon.trader.api.users;

/**
 * Created by zcg on 15/9/21.
 */
public class CreatedUserCommand {

    private final String name;
    private final String username;
    private final String password;

    public CreatedUserCommand(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
