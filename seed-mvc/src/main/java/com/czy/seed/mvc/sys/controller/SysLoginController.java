package com.czy.seed.mvc.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by PLC on 2017/5/21.
 */

@Controller
@RequestMapping("/sys/login")
public class SysLoginController {

    @RequestMapping(value = "/login1",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        return "success";
    }

    public String logout() {
        return "false";
    }
}
