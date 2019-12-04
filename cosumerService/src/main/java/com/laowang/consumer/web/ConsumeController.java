package com.laowang.consumer.web;


import com.laowang.consumer.service.ConsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author laowang
 * @date 2019/12/2 16:21
 * @Description:
 */
@Slf4j
@RestController()
@RequestMapping("/api")
public class ConsumeController {

    @Autowired
    ConsumeService service;

    @GetMapping("/consume")
    public void consume() {
        String URL = "http://127.0.0.1:8083/api/server/get?appId={appId}&dbName={dbName}";
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> map = new HashMap<>();
//        map.put("appId", "11");
//        map.put("dbName", "33");
//        JSONObject forObject = restTemplate.getForObject(URL, JSONObject.class, map);

        String str = service.doService();
        log.info(">>> jsonObject = [{}]", str);
    }
}
