package com.service.api.service;

import com.service.api.dto.User;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by @author BG331145 杨威 on 2018/12/4 0004 - 20:35
 */
@RequestMapping("/refactor")
public interface HelloService {
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;
    
    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
    
    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
