package com.example.system_demo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.example.system_demo.mapper")
public class SystemDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemDemoApplication.class, args);
    }

}
