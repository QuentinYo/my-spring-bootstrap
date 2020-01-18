package me.yukuixing.springwebdemo.proxy;

import me.yukuixing.springwebdemo.aop.LogExecutionTime;
import me.yukuixing.springwebdemo.biz.UserBiz;
import me.yukuixing.springwebdemo.common.model.User;
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

    @Autowired private UserBiz userBiz;

    public void saveUser(User user) {
        userBiz.saveUser(user);
    }

    @LogExecutionTime
    public User getUserById(long id) {
        return userBiz.getUserById(id);
    }
}
