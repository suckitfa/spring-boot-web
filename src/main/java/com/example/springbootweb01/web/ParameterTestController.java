package com.example.springbootweb01.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {
    // 测试路径变量
    // /car/1
    // /car/{id}/owner/{username}
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(
            @PathVariable("id") Integer id,
            @PathVariable("username") String username,
            @PathVariable Map<String,String> pv
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",username);
        map.put("pv",pv);
        return map;
    }
}
