package com.laowang.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laowang
 * @date 2019/12/3 17:25
 * @Description:
 */
@FeignClient(value = "product", contextId = "feignService")
@RequestMapping("/api/product")
public interface FeignService {
    @GetMapping("/api/server/get")
    public String product(@RequestParam("appId") String appId,
                          @RequestParam("dbName") String dbName);
}
