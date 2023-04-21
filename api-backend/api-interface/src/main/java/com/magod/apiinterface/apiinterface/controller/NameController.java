package com.magod.apiinterface.apiinterface.controller;

import com.magod.apiclientapisdk.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: api-interface
 * @description:
 * @author: ma
 * @create: 2023-04-11 17:58
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(@RequestParam("name") String name){
        return "Get 你的名字是:" +name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam("name") String name){
        return "Post 你的名字是:" +name;
    }

    @PostMapping("/user")
    public String getUserName(@RequestBody User user, HttpServletRequest httpRequest){
        return "Post 用户名是:" +user.getName();
    }
}
