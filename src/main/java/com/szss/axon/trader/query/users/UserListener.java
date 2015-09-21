package com.szss.axon.trader.query.users;

import com.szss.axon.trader.api.users.UserCreatedEvent;
import com.szss.axon.trader.query.users.repositories.UserQueryRepository;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zcg on 15/9/21.
 */
@Component
public class UserListener {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @EventHandler
    public void handlerUserCreated(UserCreatedEvent event) {
        UserEntity user = new UserEntity(event.getName(), event.getUsername(), event.getPassword());
        userQueryRepository.save(user);
    }
}
