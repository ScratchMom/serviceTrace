package com.laowang.consumer.api.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author laowang
 * @date 2019/12/2 11:43
 * @Description:
 */
public class ApiRequestContextInterceptor implements RequestInterceptor {
    public ApiRequestContextInterceptor() {
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ApiRequestContext apiRequestContext = ApiRequestContext.get();
        if (apiRequestContext.getTraceId() != null) {
            requestTemplate.header(ApiRequestContext.HEADER_TRACE_ID, new String[]{String.valueOf(apiRequestContext.getTraceId())});
        }
    }
}
