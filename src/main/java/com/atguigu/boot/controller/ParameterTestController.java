package com.atguigu.boot.controller;

import jakarta.servlet.http.Cookie;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") int id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam Map<String, String> params) {

        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);

        map.put("header", header);

//        map.put("age", age);
//        map.put("inters", inters);
        map.put("params", params);

        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();

        map.put("content", content);
        return map;
    }

    @GetMapping("/cars/sell")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand) {
        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        return map;

    }
}
