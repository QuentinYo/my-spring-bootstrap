package me.yukuixing.springwebdemo.interceptors;


import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * LoggerInterceptor
 *
 * @author: yukuixing
 * @since : 2020-01-04 13:20
 */
@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("[preHandle][{}][{}]{}", request, request.getMethod(), request.getRequestURI() + getParameters(request));

        return true;
    }

    private String getParameters(HttpServletRequest request) {
        StringBuilder posted = new StringBuilder();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
            while (e.hasMoreElements()) {
                if (posted.length() > 1) {
                    posted.append("&");
                }
                String curr = (String) e.nextElement();
                posted.append(curr).append("=").append(request.getParameter(curr));
            }
        }

        if (posted.length() > 1) {
            posted.append("&");
        }
        String ip = getRemoteAddr(request);
        if (StringUtils.isNotBlank(ip)) {
            posted.append("_psip=").append(ip);
        }
        return posted.toString();
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (StringUtils.isNotBlank(ipFromHeader)) {
            log.debug("ip from proxy - X-FORWARDED-FOR : {}", ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("[postHandle][{}]", request);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("[afterCompletion][{}]]", request, ex);
    }
}
