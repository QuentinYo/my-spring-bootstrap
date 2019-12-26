package me.yukuixing.springwebdemo.dao.slave;

import me.yukuixing.springwebdemo.common.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * UserDao
 *
 * @author: yukuixing
 * @since : 2019-12-24 23:44
 */
//@Mapper
public interface UserSlaveDao {

    User getUserById(@Param("id") long id);
}
