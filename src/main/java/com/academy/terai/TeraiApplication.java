package com.academy.terai;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan({"com.academy.terai.Controller"})
@ComponentScan({"com.academy.terai.Repository"})
@ComponentScan({"com.academy.terai.Model"})
@ComponentScan({"com.academy.terai.Service"})
@ComponentScan({"com.academy.terai.config"})
@ComponentScan({"com.academy.terai.Validation"})
public class TeraiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeraiApplication.class, args);
    }

}
