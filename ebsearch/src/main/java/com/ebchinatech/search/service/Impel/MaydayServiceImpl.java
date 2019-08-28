package com.ebchinatech.search.service.Impel;


import com.ebchinatech.search.mapper.MaydayMapper;
import com.ebchinatech.search.model.Mayday;
import com.ebchinatech.search.service.MaydayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MaydayService")
public class MaydayServiceImpl implements MaydayService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MaydayMapper maydayMapper;

    @Override
    public void create(String title, Integer content) {
        jdbcTemplate.update("insert into Mayday(title,content) values(?,?)", title, content);
    }


    @Override
    public void deleteByTitle(String title) {
        jdbcTemplate.update("delete from Mayday where Title = ?", title);
    }

    @Override
    public List<Mayday> search(String search, int page) {
        Mayday keywords = new Mayday();
        keywords.setContent(search);
        keywords.setTitle(search);
        // 页面容量
        int pageCount = 3, pageStart = pageCount * (page - 1);
        //总页数
        int totalRecord = maydayMapper.getRecord(keywords);
        int Pages = totalRecord % pageCount;
        int totalPage = totalRecord / pageCount + Pages != 0 ? 1 : 0;


        return maydayMapper.findByNameAndPassword(keywords, pageStart, pageCount);
    }

    public int totalPages(String totalpages) {
        Mayday keywords = new Mayday();
        keywords.setTitle(totalpages);
        keywords.setContent(totalpages);
        int pageCount = 3;
        int totalRecord = maydayMapper.getRecord(keywords);
        int Pages = totalRecord % pageCount;
        System.out.println(Pages);
        System.out.println(totalRecord/pageCount);

        return totalRecord / pageCount + (Pages != 0 ? 1 : 0);


    }


}