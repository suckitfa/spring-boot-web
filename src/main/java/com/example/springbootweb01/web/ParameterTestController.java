package com.example.springbootweb01.web;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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

    // /cars/sell;low=44,brand=byd,audi,yd
    // SpringBoot默认禁用了矩阵变量的功能，手动开启：自定义SpringNVC
    // 矩阵变量必须要有路径变量才能够被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(
           @MatrixVariable("low") Integer low,
           @MatrixVariable("brand") List<String> brandList,
           @PathVariable("path") String path
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brandList);
        map.put("path",path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(
           @MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
           @MatrixVariable(value = "age",pathVar = "empId") Integer empAge
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
