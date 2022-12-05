package com.example.springbootweb01.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/dog.jpeg")
    public String test() {
        return "TestBug.jpg";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @RequestMapping("/model")
    public String testModel(Model model) {
        return model.toString();
    }
}
