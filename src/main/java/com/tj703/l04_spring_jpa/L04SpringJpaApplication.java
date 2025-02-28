package com.tj703.l04_spring_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources(@PropertySource("classpath:/env.properties"))
//spring 이 실행될때 해당 설정을 포함하겠다.
public class L04SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(L04SpringJpaApplication.class, args);
    }

}
