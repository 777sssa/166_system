package com.example.system_demo.service;

import com.example.system_demo.entity.Paper;
import com.example.system_demo.entity.User;
import com.example.system_demo.mapper.PaperMapper;
import com.example.system_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PaperMapper paperMapper;


    // 注册
    public String register(User user) {
        if (userMapper.getUserByUsername(user.getUsername()) != null) {
            return null; // 用户名已存在，返回 null
        }
        userMapper.insertUser(user);
        return user.getUsername(); // 返回用户名
    }


    // 更新兴趣方法
    public String updateHobbies(String username, List<String> hobbies) {
        String hobbiesString = String.join(",", hobbies); // 将兴趣列表转化为逗号分隔的字符串
        int result = userMapper.updateHobbies(username, hobbiesString);
        return result > 0 ? "Hobbies updated successfully" : "User not found";
    }

    // 登录
    public List<Paper> login(String username, String password) {
        User user = userMapper.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            // 将用户的兴趣字符串转为 List<String>
            List<String> interests = Arrays.asList(user.getHobbies().split(","));
            // 查询符合兴趣的论文
            return paperMapper.searchPapersByInterests(interests);
        } else {
            return null; // 登录失败
        }
    }


}
