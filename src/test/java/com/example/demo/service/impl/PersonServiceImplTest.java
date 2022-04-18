package com.example.demo.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PersonServiceImplTest {

    @Resource
    PersonServiceImpl personService;

    @Test
    void test1() {
        personService.test();
    }
}