package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.vo.PersonVo;

import java.util.List;

public interface PersonService {
    int test();

    PersonVo find(Integer indx);

    void performInsert();

}
