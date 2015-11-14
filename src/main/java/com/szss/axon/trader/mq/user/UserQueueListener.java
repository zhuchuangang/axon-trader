package com.szss.axon.trader.mq.user;

import com.szss.axon.trader.api.users.UserCreatedEvent;
import com.szss.axon.trader.mapper.UserMapper;
import com.szss.axon.trader.query.users.UserEntity;
import com.szss.axon.trader.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zcg on 15/11/14.
 */
@Component
public class UserQueueListener {
    public static final String USER_QUEUE = "axon.user.queue";

    @Autowired
    private UserService userService;

    @RabbitListener(queues = USER_QUEUE)
    public void save(UserEntity user) {
        userService.save(user);
    }
}
