package com.atguigu.boot.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了...");
        request.setAttribute("code", 200);
        return "forward:success";
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        map.put("hello", "world");
        model.addAttribute("world", "hello");
        request.setAttribute("message", "HelloWorld");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> goToPage2(@RequestAttribute("msg") String msg,
                                         @RequestAttribute("code") Integer code,
                                         HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();

        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        map.put("code", code);
        return map;
    }
}
