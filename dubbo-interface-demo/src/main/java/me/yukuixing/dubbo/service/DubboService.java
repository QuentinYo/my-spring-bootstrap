package me.yukuixing.dubbo.service;

import me.yukuixing.dubbo.dto.UserInfoDto;

/**
 * DubboService
 *
 * @author: yukuixing
 * @since : 2020-01-17 15:18
 */
public interface DubboService {
    UserInfoDto getUserInfo(long userId);
}
