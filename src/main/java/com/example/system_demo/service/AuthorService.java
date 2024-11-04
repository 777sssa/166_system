package com.example.system_demo.service;

import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.mapper.AuthorMapper;
import com.example.system_demo.mapper.PaperMapper;
import com.example.system_demo.vo.AuthorProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private PaperMapper paperMapper;

    // 1. 返回所有作者结果
    public List<AuthorProfileVO> findAll() {
        return authorMapper.findAllAuthorProfiles();
    }

    // 2. 精确搜索
    public AuthorProfileVO getAuthorProfileById(String id) {
        return authorMapper.findAuthorProfileById(id);
    }

    public List<Paper> getPapersByAuthorId(String id) {
        return paperMapper.findByAuthorId(id);
    }

    public List<AuthorProfileVO> getSimilarAuthorsById(String id) {
        // 根据 author_id 获取相似作者的 id 列表
        List<String> similarAuthorIds = authorMapper.findSimilarAuthorsByAuthorId(id);
        if (!similarAuthorIds.isEmpty()) {
            // 根据相似作者的 id 列表获取相似作者的详细信息
            return authorMapper.findAuthorProfilesByIds(similarAuthorIds);
        }
        return Collections.emptyList();
    }

    public List<AuthorProfileVO> getRecommendAuthorsById(String id) {
        // 根据 author_id 获取相似作者的 id 列表
        List<String> similarAuthorIds = authorMapper.findRecommendAuthorsByAuthorId(id);
        if (!similarAuthorIds.isEmpty()) {
            // 根据相似作者的 id 列表获取相似作者的详细信息
            return authorMapper.findAuthorProfilesByIds(similarAuthorIds);
        }
        return Collections.emptyList();
    }



    // 3. 模糊搜索
    public List<Author> findAuthorsByName(String name) {
        return authorMapper.findAuthorsByName(name);
    }


}