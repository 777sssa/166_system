package com.example.system_demo.mapper;

import com.example.system_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    // 插入新用户（注册）
    @Insert("INSERT INTO users(username, password, hobbies) VALUES(#{username}, #{password}, #{hobbies})")
    void insertUser(User user);

    //插入兴趣点
    @Update("UPDATE users SET hobbies = #{hobbies} WHERE username = #{username}")
    int updateHobbies(@Param("username") String username, @Param("hobbies") String hobbies);

    // 根据用户名查询用户（登录）
    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User getUserByUsernameAndPassword(String username, String password);

    // 根据用户名查询用户（检查是否已存在）
    @Select("SELECT * FROM users WHERE username = #{username}")
    User getUserByUsername(String username);
}

