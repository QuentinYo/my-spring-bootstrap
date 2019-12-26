package me.yukuixing.springwebdemo.service;

import me.yukuixing.springwebdemo.common.model.User;

/**
 * UserService
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:50
 */
public interface UserService {

    void saveUser(User user);

    User getUserById(long id);
}
