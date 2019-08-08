package com.how2java.springboot.service;
import java.util.List;







import com.how2java.springboot.model.Mayday;

public interface MaydayService {
    void create(String Title, Integer title);
    void deleteByTitle(String title);

}