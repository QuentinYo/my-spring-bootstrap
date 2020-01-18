package me.yukuixing.dubbo.biz;

import me.yukuixing.dubbo.dao.master.UserDao;
import me.yukuixing.dubbo.dao.slave.UserSlaveDao;
import me.yukuixing.dubbo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserBiz
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:57
 */
@Service
public class UserBiz {

    @Autowired private UserDao userDao;
    @Autowired private UserSlaveDao userSlaveDao;

    public void saveUser(UserInfo user) {
        userDao.saveUser(user);
    }

    public UserInfo getUserById(long id) {
        return userSlaveDao.getUserById(id);
    }
}
