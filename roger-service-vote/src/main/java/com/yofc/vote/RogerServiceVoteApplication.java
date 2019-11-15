package com.yofc.vote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
@EnableSwagger2
@ComponentScan("com.yofc")
@MapperScan("com.yofc.dal.vote.mapper")
public class RogerServiceVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(RogerServiceVoteApplication.class, args);
    }

}
