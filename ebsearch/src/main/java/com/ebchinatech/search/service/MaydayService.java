package com.ebchinatech.search.service;
import java.util.List;


import com.ebchinatech.search.model.Mayday;

public interface MaydayService {
    void create(String Title, Integer title);
    void deleteByTitle(String title);

    List<Mayday> search(String search, int page);
//    MaydaySearch(String keywords);

    int totalPages(String totalpages);


}