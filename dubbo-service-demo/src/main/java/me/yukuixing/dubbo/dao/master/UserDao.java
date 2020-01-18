package me.yukuixing.dubbo.dao.master;

import me.yukuixing.dubbo.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * UserDao
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:44
 */
public interface UserDao {

    void saveUser(@Param("user") UserInfo user);
}
