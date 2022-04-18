package com.example.demo.service.impl;

import com.example.demo.service.Demo2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Demo2ServiceImpl implements Demo2Service {
    @Override
    public void A() {
        log.info("执行A功能");
    }

    @Override
    public void B() throws Exception{
        Thread.sleep(10000);
        log.info("执行B功能");
    }

    @Override
    public void AB() {
        A();
        try {
            B();
        } catch (Exception e) {
            log.error("B功能异常");
        }
    }
}
