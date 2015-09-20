package com.szss.axon.trader.api.users;

/**
 * Created by zcg on 15/9/18.
 */
public class AuthenticateUserCommand {

    private String username;
    private String password;

    public AuthenticateUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
