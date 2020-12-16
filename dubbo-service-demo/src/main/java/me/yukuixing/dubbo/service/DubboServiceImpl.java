package me.yukuixing.dubbo.service;

import me.yukuixing.dubbo.biz.UserBiz;
import me.yukuixing.dubbo.dto.UserInfoDto;
import me.yukuixing.dubbo.model.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DubboServiceImpl
 *
 * @author: yukuixing
 * @since : 2020-01-17 17:39
 */
@Service(version = "1.0.0")
@Component
public class DubboServiceImpl implements DubboService {

    @Autowired
    private UserBiz userBiz;

    @Override
    public UserInfoDto getUserInfo(long userId) {
        User user = userBiz.getUserById(userId);
        UserInfoDto userInfoDto = new UserInfoDto();
        if (user == null) {
            return userInfoDto;
        }

        userInfoDto.setId(user.getId());
        userInfoDto.setAge(user.getAge());
        userInfoDto.setUserName(user.getName());
        userInfoDto.setCreateTime(user.getCreateTime());
        return userInfoDto;
    }
}
