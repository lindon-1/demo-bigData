package com.example.demo.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.example.demo.dao.PersonMapper;
import com.example.demo.entity.Performance;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.vo.PersonVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    PersonMapper personMapper;

    @Override
    public int test() {
        long start = System.currentTimeMillis();
        List<Person> peoples = new ArrayList<>();
        int num = 20000000;
        for (int i = 0; i < num; i++) {
            Person person = new Person();
            person.setAddress("地址" + i);
            person.setAddressType("地址类型" + i);
            person.setAge(i);
            person.setFileType("文件类型" + i);
            person.setLocation("位置" + i);
            person.setName("名称" + i);
            person.setNickName("昵称" + i);
            person.setType("类型" + i);
            peoples.add(person);
            if (peoples.size() %1000 == 0) {
                int suc = personMapper.batchSave(peoples);
                System.out.println("save success :" + suc);
                peoples.clear();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start)/60000 + " min");
        return 0;
    }

    @Override
    public void performInsert() {

        int num = 100;
        LocalDate now = LocalDate.now();
        List<Performance> list = new ArrayList<>();
        Random random = new Random(100);
        for (int i = 0; i < num; i++) {
            Performance performance = new Performance();
            list.add(performance);
            performance.setName("小小");
            performance.setScore(random.nextInt(100));
            performance.setTime(now.format(DateTimeFormatter.ofPattern(DatePattern.PURE_DATE_PATTERN)));
            now = now.minusDays(1);
        }
        personMapper.performInsert(list);

    }




    @Override
    public PersonVo find(Integer indx) {
        Integer index = 0;
        if (!Objects.isNull(indx)) {
            index = indx;
        }

        Integer limit = 10;
        long start = System.currentTimeMillis();
//        List<Person> personList = personMapper.find(index, limit);
        List<Person> personList = personMapper.findOpt(index, limit);
        long end = System.currentTimeMillis();
        String msg = "耗时:" + (end - start) + " ms";
        log.info(msg);
        PersonVo personVo = new PersonVo();
        personVo.setMsg(msg);
        personVo.setPersons(personList);
        return personVo;
    }


}
