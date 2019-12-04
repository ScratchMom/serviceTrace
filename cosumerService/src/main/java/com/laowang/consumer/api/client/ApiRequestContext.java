package com.laowang.consumer.api.client;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;

/**
 * @author laowang
 * @date 2019/12/2 11:16
 * @Description:
 */
@Data
@Builder
public class ApiRequestContext {
    private Long traceId;
    public static final String HEADER_TRACE_ID = "X-Trace_Id";
    public static final Long DEFAULT_TRACE_ID = -1L;

    private static TransmittableThreadLocal<ApiRequestContext> contextHolder = new TransmittableThreadLocal<ApiRequestContext>() {
        @Override
        public ApiRequestContext copy(ApiRequestContext parentValue) {
            return ApiRequestContext.builder().traceId(DEFAULT_TRACE_ID).build();
        }
    };

    public static ApiRequestContext get() {
        return contextHolder.get();
    }

    public static void init(HttpServletRequest request) {
        if (StringUtils.isNotBlank(request.getHeader(HEADER_TRACE_ID))) {
            ApiRequestContext context = ApiRequestContext.builder()
                    .traceId(Long.valueOf(request.getHeader(HEADER_TRACE_ID)))
                    .build();
            MDC.put(HEADER_TRACE_ID, String.valueOf(request.getHeader(HEADER_TRACE_ID)));
            contextHolder.set(context);
            return;
        }
        // 如果header没有，设置默认值
        ApiRequestContext context = ApiRequestContext.builder()
                .traceId(DEFAULT_TRACE_ID)
                .build();
        MDC.put(HEADER_TRACE_ID, String.valueOf(DEFAULT_TRACE_ID));
        contextHolder.set(context);
    }
}
