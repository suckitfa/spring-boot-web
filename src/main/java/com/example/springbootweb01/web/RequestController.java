package com.example.springbootweb01.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg","成功了..........");
        request.setAttribute("code",200);
        return "forward:/success"; // 转发到success， el表达式？
    }
    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(
             @RequestAttribute("msg") String msg,
            @RequestAttribute("code") Integer code,
             @RequestAttribute Map<String,String> attrs
    ) {
        Map<String,Object> map = new HashMap<>();
        map.put("request_attribute",attrs);
        return map;
    }

}
