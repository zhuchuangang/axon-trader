package com.szss.axon.trader.webui.controller;

import com.szss.axon.trader.api.users.AuthenticateUserCommand;
import com.szss.axon.trader.query.users.UserEntity;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zcg on 15/9/18.
 */
@Controller
@RequestMapping("/main")
public class LoginController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, String password, Model model) {
        AuthenticateUserCommand command = new AuthenticateUserCommand(username, password);
        FutureCallback<UserEntity> futureCallback = new FutureCallback<UserEntity>();
        commandBus.dispatch(new GenericCommandMessage<AuthenticateUserCommand>(command), futureCallback);
        UserEntity user = futureCallback.getResult();
        model.addAttribute("user", user);
        return "/main/login";
    }
}
