package me.yukuixing.dubbo.dao.slave;

import me.yukuixing.dubbo.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * UserDao
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:44
 */
// @Mapper
public interface UserSlaveDao {

    UserInfo getUserById(@Param("id") long id);
}
