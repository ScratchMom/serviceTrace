package com.laowang.consumer.api.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author laowang
 * @date 2019/12/2 15:48
 * @Description:
 */
@Slf4j
public class CycleFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        this.createApiRequestContext(request);
        try {
            filterChain.doFilter(request, response);

        } finally {
            logger.info("CycleFilter doFilter...");
        }
    }

    private void createApiRequestContext(final HttpServletRequest request) {
        if (request == null) {
            logger.info("HttpServletRequest is empty!");
        } else {
            ApiRequestContext.init(request);
        }
    }
}
