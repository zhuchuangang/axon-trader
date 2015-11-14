package com.szss.axon.trader.user.command;

import com.szss.axon.trader.api.users.UserCreatedEvent;
import com.szss.axon.trader.api.users.UserId;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Created by zcg on 15/9/21.
 */
public class User extends AbstractAnnotatedAggregateRoot {
    private static final long serialVersionUID = 329141135983239150L;
    @AggregateIdentifier
    private UserId userId;
    private String name;
    private String username;
    private String password;

    public User() {
    }

    public User(UserId userId, String name, String username, String password) {
        apply(new UserCreatedEvent(userId, name, username, password));
    }

    @EventHandler
    public void userCreatedEventHandle(UserCreatedEvent event) {
        this.userId = event.getUserId();
        this.name = event.getName();
        this.password = event.getPassword();
        this.username = event.getUsername();
    }

    @Override
    public UserId getIdentifier() {
        return this.userId;
    }
}
