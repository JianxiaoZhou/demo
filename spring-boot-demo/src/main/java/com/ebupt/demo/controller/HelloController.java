package com.ebupt.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    public Map<String,Object> hello(){
        Map<String ,Object > map = new HashMap<>();
        map.put("id",1);
        map.put("name","张三");
        map.put("age",12);
        return map;
    }
}
