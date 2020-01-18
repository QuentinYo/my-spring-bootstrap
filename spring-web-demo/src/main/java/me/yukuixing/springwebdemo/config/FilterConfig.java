package me.yukuixing.springwebdemo.config;

import com.google.common.collect.Lists;
import me.yukuixing.springwebdemo.filters.LogCostTimeFilter;
import me.yukuixing.springwebdemo.filters.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FilterConfig
 *
 * @author: yukuixing
 * @since : 2020-01-04 17:26
 *     <p>https://stackoverflow.com/questions/6560969/how-to-define-servlet-filter-order-of-execution-using-annotations-in-war
 *     https://stackoverflow.com/questions/25957879/filter-order-in-spring-boot
 *     https://fanlychie.github.io/post/spring-boot-servlet-filter-listener-usage.html
 *     通过WebFilter注解的方式无法指定filter的顺序
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {
        FilterRegistrationBean<LogFilter> registration =
                new FilterRegistrationBean<>(new LogFilter());
        // 指定顺序
        registration.setOrder(0);
        // 指定应用此filter的请求路径
        registration.setUrlPatterns(Lists.newArrayList("/*"));
        return registration;
    }

    @Bean
    public FilterRegistrationBean<LogCostTimeFilter> logCostTimeFilter() {
        FilterRegistrationBean<LogCostTimeFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LogCostTimeFilter());
        registrationBean.setOrder(-100);
        return registrationBean;
    }
}
