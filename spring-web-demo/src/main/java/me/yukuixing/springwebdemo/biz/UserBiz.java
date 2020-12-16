package me.yukuixing.springwebdemo.biz;

import javax.annotation.Resource;
import me.yukuixing.dubbo.model.User;
import me.yukuixing.springwebdemo.dao.master.UserDao;
import me.yukuixing.springwebdemo.dao.slave.UserSlaveDao;
import org.springframework.stereotype.Service;

/**
 * UserBiz
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:57
 */
@Service
public class UserBiz {

    @Resource
    private UserDao userDao;
    @Resource
    private UserSlaveDao userSlaveDao;

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public User getUserById(long id) {
        return userSlaveDao.getUserById(id);
    }
}
