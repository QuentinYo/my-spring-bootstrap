package me.yukuixing.springwebdemo.dao.master;

import me.yukuixing.springwebdemo.common.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * UserDao
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:44
 */
public interface UserDao {

    void saveUser(@Param("user") User user);
}
