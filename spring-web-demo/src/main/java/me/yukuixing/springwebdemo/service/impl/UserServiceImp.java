package me.yukuixing.springwebdemo.service.impl;

import me.yukuixing.springwebdemo.biz.UserBiz;
import me.yukuixing.springwebdemo.common.model.User;
import me.yukuixing.springwebdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImp
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:51
 */
@Service("userService")
public class UserServiceImp implements UserService {

    @Autowired
    private UserBiz userBiz;

    @Override
    public void saveUser(User user) {
        userBiz.saveUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userBiz.getUserById(id);
    }
}
