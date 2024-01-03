package com.taoai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.taoai.mapper")
@SpringBootApplication
public class TaoAiDianPingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaoAiDianPingApplication.class, args);
    }

}
