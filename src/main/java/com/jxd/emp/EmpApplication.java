package com.jxd.emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName EmpApplication
 * @Description TODO
 * @Author linyafei
 * @Date 2020/10/22
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.jxd")//默认扫描emp包
@MapperScan("com.jxd.emp.mapper")
public class EmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpApplication.class);
    }
}
