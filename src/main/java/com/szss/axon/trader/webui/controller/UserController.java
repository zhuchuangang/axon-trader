package com.szss.axon.trader.webui.controller;

import com.szss.axon.trader.api.users.CreatedUserCommand;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zcg on 15/9/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping("/add")
    public String addUser(Model model){
        CreatedUserCommand command=new CreatedUserCommand("笑天","sxt","123");
        CommandMessage message=new GenericCommandMessage(command);
        commandBus.dispatch(message);
        return "/user/addUser";
    }

}
