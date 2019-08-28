package com.ebchinatech.search.mapper;
import com.ebchinatech.search.model.Mayday;
import java.util.List;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface MaydayMapper {
    @Select("SELECT * FROM `mayday` where title like concat('%', #{mayday.title},'%') or content like concat('%', #{mayday.content},'%') " +
            "limit #{pageStart}, #{pageCount};")
    List<Mayday> findByNameAndPassword(@Param("mayday") Mayday mayday, @Param("pageStart") int pageStart, @Param("pageCount") int pageCount);

    @Select("SELECT count(id) FROM mayday where title like concat('%', #{mayday.title},'%') or content like concat('%', #{mayday.content},'%');" )
    int getRecord(@Param("mayday") Mayday mayday);

    @Select("SELECT * FROM `mayday` where title = #{title} and content = #{content};")
    List<Mayday> findByAdminWithPage(Mayday mayday, int start, int end);

    @Insert("INSERT INTO `mayday` (`id`, `title`, `content`, `href`) VALUES (null, #{title}, #{content}, #{href});")
    int insert(Mayday mayday);

    @Update("UPDATE `mayday` SET `` title= #{title}, `content` = #{content},WHERE `id` = #{id};")
    int updateHrefById(int id);

    @Delete("DELETE FROM `mayday` WHERE id  = #{id}")
    int deleteById(int id);

}
