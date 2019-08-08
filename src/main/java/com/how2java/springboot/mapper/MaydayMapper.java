package com.how2java.springboot.mapper;
import java.util.List;

import com.how2java.springboot.model.Mayday;
import org.apache.ibatis.annotations.*;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface MaydayMapper {
    @Select("SELECT * FROM `mayday` where title like concat('%', #{title},'%') or content like concat('%', #{content},'%');")
    List<Mayday> findByNameAndPassword(Mayday mayday);

    @Select("SELECT * FROM `mayday` where title = #{title} and content = #{content};")
    List<Mayday> findByAdminWithPage(Mayday mayday, int start, int end);

    @Insert("INSERT INTO `mayday` (`id`, `title`, `content`, `href`) VALUES (null, #{title}, #{content}, #{href});")
    int insert(Mayday mayday);

    @Update("UPDATE `mayday` SET `` title= #{title}, `content` = #{content},WHERE `id` = #{id};")
    int updateHrefById(int id);

    @Delete("DELETE FROM `mayday` WHERE id  = #{id}")
    int deleteById(int id);

}
