package com.example.system_demo.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.system_demo.dto.InterestRequest;
import com.example.system_demo.entity.Author;
import com.example.system_demo.entity.Paper;
import com.example.system_demo.service.AuthorService;
import com.example.system_demo.service.PaperService;
import com.example.system_demo.vo.AuthorProfileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paper")
public class PaperController {

        @Autowired
        private PaperService paperService;

        // 模糊搜索-论文名
        @GetMapping("/findByPaperName")
        public ResponseEntity<?> findByPaperName(@RequestParam String name) {
            List<Paper> papers = paperService.findPapersByName(name);
            return ResponseEntity.ok(papers);
        }


}
