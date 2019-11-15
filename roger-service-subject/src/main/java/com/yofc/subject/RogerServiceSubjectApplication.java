package com.yofc.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
@EnableSwagger2
@MapperScan("com.yofc.dal.subject.mapper")
public class RogerServiceSubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RogerServiceSubjectApplication.class, args);
    }

}
