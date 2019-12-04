package com.laowang.consumer.service;

import com.laowang.consumer.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author laowang
 * @date 2019/12/3 17:40
 * @Description:
 */
@Service
public class ConsumeService {
    @Autowired
    private FeignService feignService;

    public String doService(){
        String str = feignService.product("111", "222");
        return str;
    }
}
