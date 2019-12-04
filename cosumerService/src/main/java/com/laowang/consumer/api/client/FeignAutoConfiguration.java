package com.laowang.consumer.api.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laowang
 * @date 2019/12/2 17:22
 * @Description:
 */
@Slf4j
@Configuration
public class FeignAutoConfiguration {
    public FeignAutoConfiguration() {
    }

    @Bean
    FilterRegistrationBean apiRequestContextFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new CycleFilter());
        bean.setOrder(-111);
        log.info(">>> FeignAutoConfiguration apiRequestContextFilter");
        return bean;
    }

//    @Bean
//    FilterRegistrationBean loggerFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.setFilter(null);
//        bean.setOrder(-111);
//        log.info(">>> FeignAutoConfiguration loggerFilter");
//
//        return bean;
//    }

    @Bean
    ApiRequestContextInterceptor apiRequestContextInterceptor() {
        log.info(">>> FeignAutoConfiguration apiRequestContextInterceptor");
        return new ApiRequestContextInterceptor();
    }
}
