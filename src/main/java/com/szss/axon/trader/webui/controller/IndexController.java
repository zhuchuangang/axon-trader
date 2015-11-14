package com.szss.axon.trader.webui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zcg on 15/11/14.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "/index";
    }
}
