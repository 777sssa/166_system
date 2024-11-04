package com.example.system_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.vo.AuthorProfileVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface PaperMapper {

//  通过作者id查询所有论文
    List<Paper> findByAuthorId(@Param("authorId") String authorId);


//  通过论文名称模糊查询，返回所有符合条件的论文信息
    List<Paper> findPapersByName(@Param("name") String name);


// 根据兴趣搜索论文
    List<Paper> searchPapersByInterests(@Param("interests") List<String> interests);


}