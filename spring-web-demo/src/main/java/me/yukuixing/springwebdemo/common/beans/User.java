package me.yukuixing.springwebdemo.common.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * User
 *
 * @author: yukuixing
 * @since : 2019-11-24 17:40
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:app.properties")
public class User {

    private String name;

    private String password;
}
