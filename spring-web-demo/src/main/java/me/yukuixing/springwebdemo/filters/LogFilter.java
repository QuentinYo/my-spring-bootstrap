package me.yukuixing.springwebdemo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * LogFilter
 *
 * @author: yukuixing
 * @since : 2020-01-04 16:37
 */
@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        log.info("Logging Request. {}:{}", req.getMethod(), req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Logging Response: {}", res.getHeaderNames());
    }
}
