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
        String str = service.doService();
        log.info(">>> jsonObject = [{}]", str);
    }
}
