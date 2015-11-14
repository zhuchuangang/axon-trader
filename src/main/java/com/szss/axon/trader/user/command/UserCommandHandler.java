package com.szss.axon.trader.user.command;

import com.szss.axon.trader.api.users.AuthenticateUserCommand;
import com.szss.axon.trader.api.users.CreatedUserCommand;
import com.szss.axon.trader.api.users.UserId;
import com.szss.axon.trader.query.users.UserEntity;
import com.szss.axon.trader.query.users.repositories.UserQueryRepository;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zcg on 15/9/18.
 */
@Component
public class UserCommandHandler {
    @Autowired
    private UserQueryRepository userQueryRepository;

    @Autowired
    private Repository<User> userRepository;

    @CommandHandler
    public UserEntity authenticateUserCommandHandler(AuthenticateUserCommand authenticateUserCommand) {
        String username = authenticateUserCommand.getUsername();
        String password = authenticateUserCommand.getPassword();
        UserEntity user = userQueryRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @CommandHandler
    public void createdUserCommandHandler(CreatedUserCommand command) {
        UserId userId = new UserId();
        User user = new User(userId, command.getName(), command.getUsername(), command.getPassword());
        userRepository.add(user);
    }

}
