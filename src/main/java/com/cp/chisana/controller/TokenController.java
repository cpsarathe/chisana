package com.cp.chisana.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cp.chisana.service.UserService;

import javax.annotation.Resource;

/**
 * Created by Chandra.Sarathe on 12/4/2018.
 */

@RequestMapping("/api/token")
@Controller
public class TokenController {

    @Resource(name="chUserService")
    private UserService userService;

    @RequestMapping("/verify/{token}")
    public String verifyToken(@PathVariable(value = "token") String token) {
        if(StringUtils.isEmpty(token)){
            return "error";
        }
        boolean status = userService.verifyToken(token);

        if(status) return "success";
        return "invalidtoken";
    }
}
