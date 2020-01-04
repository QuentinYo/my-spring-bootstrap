package me.yukuixing.springwebdemo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * LogCostTimeFilter
 *
 * @author: yukuixing
 * @since : 2020-01-04 16:37
 */
@Slf4j
public class LogCostTimeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        log.debug("log cost time filter ...");
        long now = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        log.debug("log cost time filter ...{}ms", System.currentTimeMillis() - now);
    }
}
