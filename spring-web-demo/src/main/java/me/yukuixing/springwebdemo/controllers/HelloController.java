package me.yukuixing.springwebdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import me.yukuixing.springwebdemo.common.beans.MyEvent;
import me.yukuixing.springwebdemo.common.model.User;
import me.yukuixing.springwebdemo.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author: yukuixing
 * @since : 2019-11-17 22:16
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private UserProxy userProxy;
    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public Object getUser(@RequestParam("id") long id) {
        publisher.publishEvent(new MyEvent(String.valueOf(id), 1));
        return userProxy.getUserById(id);
    }

    @RequestMapping(value = "createuser", method = RequestMethod.POST)
    public Object saveUser(User user) {
        if (user.getId() > 0L) {
            return "fail";
        }

        userProxy.saveUser(user);
        return "success";
    }
}
