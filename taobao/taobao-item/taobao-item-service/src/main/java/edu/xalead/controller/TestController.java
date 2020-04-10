package edu.xalead.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aaa")
public class TestController {
    @GetMapping("bbb")
    public String aaa(){
        return "Hello";
    }
}
