package com.laowang.produce.web;

import com.alibaba.fastjson.JSONObject;
import com.laowang.produce.client.ApiRequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @author laowang
 * @date 2019/12/2 16:21
 * @Description:
 */
@Slf4j
@RestController()
@RequestMapping("/api")
public class ProduceController {

    @GetMapping("/server/get")
    public String product(@RequestParam("appId") String appId,
                          @RequestParam("dbName") String dbName) {

        log.info(">>> product appId[{}],dbName[{}]", appId, dbName);
        JSONObject object = new JSONObject();
        object.put("aa", 22);
        log.info("&&&& = " + JSONObject.toJSONString(ApiRequestContext.get()));
        return object.toJSONString();
    }
}
