package com.szss.axon.trader.users.command;

import com.szss.axon.trader.api.users.AuthenticateUserCommand;
import com.szss.axon.trader.query.users.UserEntity;
import com.szss.axon.trader.query.users.repositories.UserQueryRepository;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by zcg on 15/9/18.
 */
@Component
public class UserCommandHandler {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @CommandHandler
    public UserEntity authenticateUserCommandHandler(AuthenticateUserCommand authenticateUserCommand) {
//        mongoTemplate.insert(new UserEntity("笑天", "buyer1", "123"));
//        mongoTemplate.insert(new UserEntity("二朋", "buyer2", "123"));
//        mongoTemplate.insert(new UserEntity("宝宝", "buyer3", "123"));
//        mongoTemplate.insert(new UserEntity("冷风", "buyer4", "123"));
//        mongoTemplate.insert(new UserEntity("接口", "buyer5", "123"));
        String username = authenticateUserCommand.getUsername();
        String password = authenticateUserCommand.getPassword();
        UserEntity user = userQueryRepository.findByUsername(username);
        if (user!=null&&password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

}
