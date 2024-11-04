package com.example.system_demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.service.AuthorService;
import com.example.system_demo.vo.AuthorProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // 1. 返回所有作者结果
    @GetMapping("/findAll")
    public List<AuthorProfileVO> findAll() {
        return authorService.findAll();
    }


    // 2.根据作者id返回对应信息
    @GetMapping("/findByName")
    public ResponseEntity<?> findById(@RequestParam String id) {
        // 获取作者信息
        AuthorProfileVO authorProfile = authorService.getAuthorProfileById(id);
        // 获取作者的论文
        List<Paper> papers = authorService.getPapersByAuthorId(id);
        // 获取相似作者的信息
        List<AuthorProfileVO> similarAuthors = authorService.getSimilarAuthorsById(id);
        List<AuthorProfileVO> recommendAuthors = authorService.getRecommendAuthorsById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("author", authorProfile);
        response.put("papers", papers);
        response.put("similarAuthors", similarAuthors);
        response.put("recommendAuthors", recommendAuthors);

        return ResponseEntity.ok(response);
    }


    // 3. 模糊搜索-作者名
    @GetMapping("/findByAuthorName")
    public ResponseEntity<?> findByAuthorName(@RequestParam String name) {
        List<Author> authors = authorService.findAuthorsByName(name);
        return ResponseEntity.ok(authors);
    }


}