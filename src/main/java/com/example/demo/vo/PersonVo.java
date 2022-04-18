package com.example.demo.vo;

import com.example.demo.entity.Person;

import java.util.List;

public class PersonVo {

    private List<Person> persons;

    private String msg;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
