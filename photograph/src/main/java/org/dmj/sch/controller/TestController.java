package org.dmj.sch.controller;

import org.dmj.sch.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 56821 on 2018/8/13.
 */
@RestController
public class TestController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/test")
    public Object test(){
        return userMapper.loadUsers();
    }
}
