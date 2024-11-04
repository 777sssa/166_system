package com.example.system_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

//    @Id
//    @Column(name = "id", length = 24, nullable = false)
//    private String id; // 用户ID，使用String类型来映射数据库中的varchar

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // 用户ID，使用Long类型来映射数据库中的BIGINT自增字段

    @Column(name = "username", length = 255, nullable = false)
    private String username; // 用户名

    @Column(name = "password", length = 255, nullable = false)
    private String password; // 用户密码

    @Column(name = "hobbies", columnDefinition = "TEXT")
    private String hobbies; // 用户兴趣爱好
}
