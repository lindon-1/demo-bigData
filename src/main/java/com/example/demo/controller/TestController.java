package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.Demo2Service;
import com.example.demo.service.PersonService;
import com.example.demo.vo.PersonVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class TestController {

    @Resource
    PersonService personService;

    @Resource
    Demo2Service demo2Service;

    @GetMapping(value ="/test")
    public String test() {
        log.info("这是一个日志测试的 controller");
        personService.test();
        return "这是一个日志测试的 controller";
    }

    @GetMapping(value ="/performInsert")
    public String performInsert() {
        personService.performInsert();
        return "ok";
    }

    @GetMapping(value ="/find/{index}")
    public PersonVo demo1(@PathVariable("index") Integer index) {
        log.info("这是一个日志测试的 controller");
        PersonVo personVo =  personService.find(index);
        return personVo;
    }

    @GetMapping(value ="/demo2")
    public String demo2() {
        /**
         * 控制层耦合或者业务层耦合
         * 1.页面多处调用同一个接口
         * 2.多个接口调用同一个业务层的方法
         */
        long start = System.currentTimeMillis();
        demo2Service.AB();
        long end = System.currentTimeMillis();
        String msg = "耗时：" + (end - start) + " ms";
        log.info(msg);
        return msg;
    }
}
