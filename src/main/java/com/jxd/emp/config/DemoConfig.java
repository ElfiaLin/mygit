package com.jxd.emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DemoConfig
 * @Description TODO
 * @Author linyafei
 * @Date 2020/10/23
 * @Version 1.0
 */
@Configuration
public class DemoConfig {
    //一个配置类可以代表一个xml文件，
    @Bean(name = "person")//name指定bean组件的id
    public Person getPerson() {
        //一个方法代表一个bean标签
        //这个方法返回的对象会被加载到Spring容器中
        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        return person;
    }
}
