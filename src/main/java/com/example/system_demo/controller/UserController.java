package com.example.system_demo.controller;

import com.example.system_demo.entity.Paper;
import com.example.system_demo.entity.User;
import com.example.system_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        String result = userService.register(user);
        if (result != null) {
            return ResponseEntity.ok(result); // 返回用户名
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
    }

    // 更新兴趣接口
    @PostMapping("/updateHobbies")
    public String updateHobbies(@RequestParam String username, @RequestBody List<String> hobbies) {
        return userService.updateHobbies(username, hobbies);
    }

    // 登录
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        List<Paper> recommendedPapers = userService.login(username, password);
        if (recommendedPapers != null) {
            return ResponseEntity.ok(recommendedPapers); // 返回符合兴趣的论文
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
