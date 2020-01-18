package me.yukuixing.springwebdemo.proxy;

import me.yukuixing.dubbo.dto.UserInfoDto;
import me.yukuixing.dubbo.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DubboUserProxy
 *
 * @author: yukuixing
 * @since : 2020-01-18 15:22
 */
@Service
public class DubboUserProxy {
    @Autowired private DubboService dubboService;

    public UserInfoDto getUserInfo(long userId) {
        return dubboService.getUserInfo(userId);
    }
}
