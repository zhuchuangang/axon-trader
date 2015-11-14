package com.szss.axon.trader.webui.controller;

import com.szss.axon.trader.api.users.AuthenticateUserCommand;
import com.szss.axon.trader.query.users.UserEntity;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by zcg on 15/9/18.
 */
@Controller
@RequestMapping("/main")
@SessionAttributes(value = "user")
public class LoginController {

    @Autowired
    private CommandBus commandBus;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "/main/login";
    }

    @RequestMapping(params = "method=login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        ModelMap model) {
        AuthenticateUserCommand command = new AuthenticateUserCommand(username, password);
        FutureCallback<UserEntity> futureCallback = new FutureCallback<UserEntity>();
        commandBus.dispatch(new GenericCommandMessage<AuthenticateUserCommand>(command), futureCallback);
        UserEntity user = futureCallback.getResult();
        if (user!=null) {
            return "redirect:/index";
        }else{
            return "/main/login";
        }
    }
}
