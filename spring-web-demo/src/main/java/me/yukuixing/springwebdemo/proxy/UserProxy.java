package me.yukuixing.springwebdemo.proxy;

import me.yukuixing.springwebdemo.aop.LogExecutionTime;
import me.yukuixing.springwebdemo.common.model.User;
import me.yukuixing.springwebdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserProxy
 *
 * @author: yukuixing
 * @since : 2019-12-25 00:04
 */
@Service
public class UserProxy {

    @Autowired
    private UserService userService;

    public void saveUser(User user) {
        userService.saveUser(user);
    }

    @LogExecutionTime
    public User getUserById(long id) {
        return userService.getUserById(id);
    }

}
