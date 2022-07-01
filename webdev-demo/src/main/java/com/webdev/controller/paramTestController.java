package com.webdev.controller;

import com.webdev.bean.Person;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class paramTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-e6e6fed4") String _ga,
                                     @CookieValue("Idea-e6e6fed4") Cookie cookie) {

        Map<String,Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("name", name);
//        map.put("pv", pv);
//        map.put("userAgent",userAgent);
//        map.put("headers",header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("Idea-e6e6fed4",_ga);
        System.out.println(cookie.getName()+cookie.getValue());
        return map;
    }
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content) {
        Map<String,Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    @GetMapping("/cars/{path}")
    public Map carSell(@MatrixVariable("low") List<Integer> low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path) {
        Map<String,Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }
    @GetMapping("/boss/{bossID}/{empID}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossID") Integer bossAge,
                    @MatrixVariable(value = "age", pathVar = "empID") Integer empAge) {
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empID", empAge);
        return map;

    }
    @PostMapping("/saveuser")
    public Person saveuser(Person person){

        return person;
    }

}
