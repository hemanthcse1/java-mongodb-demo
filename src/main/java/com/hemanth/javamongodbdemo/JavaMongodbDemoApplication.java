package com.hemanth.javamongodbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaMongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaMongodbDemoApplication.class, args);
        System.out.println("Hello Mongo DB");
    }

}
