package com.example.demo.controller;

import com.example.demo.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author keen1
 */
@RestController
public class HelloController {
    @Autowired
    private Car car;


    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("/")
    public String hello(){
        return "nihao";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String handle01(){
        return "hello world";
    }
}
