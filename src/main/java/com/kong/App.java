package com.kong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kong.dao")
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Spring-Boot execute!!!" );
        SpringApplication.run(App.class,args);
    }
}
