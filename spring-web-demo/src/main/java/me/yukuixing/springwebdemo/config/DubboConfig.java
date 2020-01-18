package me.yukuixing.springwebdemo.config;

import me.yukuixing.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DubboConfig
 *
 * @author: yukuixing
 * @since : 2020-01-18 15:17
 */
@EnableDubbo
@Configuration
public class DubboConfig {

    @Reference(version = "1.0.0")
    private DubboService dubboService;

    @Bean
    public DubboService dubboService() {
        return dubboService;
    }
}
