package com.how2java.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MaydayServiceImpl implements MaydayService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String title, Integer content){
        jdbcTemplate.update("insert into Mayday(title,content) values(?,?)",title,content);
    }


    @Override
    public void deleteByTitle(String title) {
        jdbcTemplate.update("delete from Mayday where Title = ?", title);
    }



}
