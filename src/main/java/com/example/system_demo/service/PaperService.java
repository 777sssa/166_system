package com.example.system_demo.service;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.mapper.AuthorMapper;
import com.example.system_demo.mapper.PaperMapper;
import com.example.system_demo.vo.AuthorProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperMapper paperMapper;

    // 1.模糊搜索-论文名
    public List<Paper> findPapersByName(String name) {
        return paperMapper.findPapersByName(name);
    }


    public List<Paper> searchPapersByInterests(List<String> interests) {
        if (interests == null || interests.isEmpty()) {
            return new ArrayList<>();
        }
        return paperMapper.searchPapersByInterests(interests);
    }


}
