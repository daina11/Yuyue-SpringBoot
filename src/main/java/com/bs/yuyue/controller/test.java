package com.bs.yuyue.controller;


import com.bs.yuyue.vo.RetResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class test {
    @PostMapping(value = "/a")
    public RetResponse newtest(Model s){
        s.addAttribute("a");
        Map<String, String> map = new HashMap<String,String>();
        map.put("ni","asd");
        s.addAllAttributes(map);
        Model a = s;
        System.out.println(s);
        return  RetResponse.SuccessRsp(s);
    }
    @GetMapping(value = "/aa")
    public String login(){
        return "login";
    }
}