package com.example.demo.dao;

import com.example.demo.entity.Performance;
import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    int batchSave(@Param("peoples") List<Person> peoples);

    List<Person> find(@Param("index") Integer index, @Param("limit") Integer limit);

    List<Person> findOpt(@Param("index") Integer index, @Param("limit") Integer limit);

    void performInsert(@Param("list") List<Performance> list);
}