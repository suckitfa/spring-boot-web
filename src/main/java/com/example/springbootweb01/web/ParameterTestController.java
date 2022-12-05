package com.example.springbootweb01.web;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {
    // 测试路径变量
    // /car/1
    // /car/{id}/owner/{username}
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(
            // 常用参数注解的使用
            // 获取路径参数
            @PathVariable("id") Integer id,
            @PathVariable("username") String username,
            @PathVariable Map<String,String> pv,
            @RequestHeader("User-Agent")  String userAgent,
            @RequestHeader Map<String,String> headers,
            // 获取请求参数 interests
            @RequestParam("interests") String[] interests,
            // 获取所有的参数
            @RequestParam Map<String,String> params
            // 获取cookie
            // @CookieValue("_ga") String _ga
            // 获取请求体的值
            ) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",username);
        map.put("pv",pv);
        map.put("User-Agent",userAgent);
        map.put("headers",headers);
        map.put("interests",interests);
        map.put("params",params);
        // map.put("_ga",_ga);
        return map;
    }

    @PostMapping("/save")
    public Map<String,Object> save(
            @RequestBody Map<String,String> content
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("params",content);
        return map;
    }
}
