package com.szss.axon.trader.api.users;

/**
 * Created by zcg on 15/9/21.
 */
public class UserCreatedEvent {
    private final UserId userId;
    private final String name;
    private final String username;
    private final String password;

    public UserCreatedEvent(UserId userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UserId getUserId() {
        return userId;
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
