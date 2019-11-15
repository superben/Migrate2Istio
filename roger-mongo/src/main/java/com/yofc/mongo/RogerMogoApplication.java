package com.yofc.mongo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yofc.dal.mapper")
public class RogerMogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RogerMogoApplication.class, args);
    }

}
