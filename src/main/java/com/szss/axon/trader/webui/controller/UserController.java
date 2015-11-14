package com.szss.axon.trader.webui.controller;

import com.szss.axon.trader.api.users.CreatedUserCommand;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zcg on 15/9/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserPage() {
        return "/user/addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model) {
        CreatedUserCommand command = new CreatedUserCommand(name, username, password);
        CommandMessage message = new GenericCommandMessage(command);
        try {
            commandBus.dispatch(message);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("success", false);
        }
        return "/user/addUser";
    }

}
