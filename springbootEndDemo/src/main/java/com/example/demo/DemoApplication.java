package com.example.demo;

import com.example.demo.bean.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author keen1
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.example.demo")
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        Pet tom = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);

        System.out.println(tom == tom2);
        boolean tom1 = run.containsBean("tom");
        System.out.println("============");
        System.out.println(tom1);
    }



}
