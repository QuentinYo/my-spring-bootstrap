package me.yukuixing.dubbo.service;

import me.yukuixing.dubbo.dto.UserInfoDto;
import org.apache.dubbo.config.annotation.Service;
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

    @Override
    public UserInfoDto getUserInfo(long userId) {
        return new UserInfoDto();
    }
}
