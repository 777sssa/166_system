package com.example.system_demo.mapper;

import com.example.system_demo.entity.Author;
import com.example.system_demo.vo.AuthorProfileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorMapper {


    List<AuthorProfileVO> findAllAuthorProfiles();

    // 根据作者 id 查询作者信息
    AuthorProfileVO findAuthorProfileById(@Param("id") String id);

    // 根据作者id查询相似/推荐作者的id列表
    List<String> findSimilarAuthorsByAuthorId(@Param("authorId") String authorId);
    List<String> findRecommendAuthorsByAuthorId(@Param("authorId") String authorId);

    // 根据相似作者id列表查询相似作者详细信息
    List<AuthorProfileVO> findAuthorProfilesByIds(@Param("list") List<String> authorIds);

    // 通过作者名模糊查询，返回所有符合条件的作者信息
    List<Author> findAuthorsByName(@Param("name") String name);
}