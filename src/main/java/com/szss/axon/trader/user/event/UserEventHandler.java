package com.szss.axon.trader.user.event;

import com.szss.axon.trader.api.users.UserCreatedEvent;
import com.szss.axon.trader.mq.user.UserQueueListener;
import com.szss.axon.trader.query.users.UserEntity;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zcg on 15/11/14.
 */
@Component
public class UserEventHandler {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @EventHandler
    public void save2db(UserCreatedEvent userCreatedEvent){
        UserEntity user = new UserEntity(userCreatedEvent.getName(), userCreatedEvent.getUsername(), userCreatedEvent.getPassword());
        user.setId(userCreatedEvent.getUserId().getIdentifier());
        rabbitTemplate.convertAndSend(UserQueueListener.USER_QUEUE,user);
    }
}
