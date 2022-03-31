package com.bs.yuyue.controller;

import com.bs.yuyue.service.CheckLoginService;
import com.bs.yuyue.service.RegisterService;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class LoginRegisterController {
    @Autowired
    RegisterService registerService;
    @Autowired
    CheckLoginService checkLoginService;

    /*注册*/
    @PostMapping(value = "/register")
    public RetResponse register(@RequestBody Map<String, Object> ci) {
        String name = (String) ci.get("username");
        String pwd = (String) ci.get("password");
        RetResponse r = registerService.register(name, pwd);
        return r;
    }

    /*登录*/
    @PostMapping(value = "/login")
    public RetResponse login(@RequestBody Map<String, Object> ci) {
        String name = String.valueOf(ci.get("username"));
        String pwd = String.valueOf(ci.get("password"));
        return checkLoginService.CheckLogin(name, pwd);
    }

    /*
     *获取用户信息
     */
    @GetMapping(value = "/getUserinfo")
    public RetResponse GetUserinfo(@RequestHeader Map headers) {
        /*获取请求头中的token也可以用GetUserinfo(HttpServletRequest request)
        String token = request.getHeader("token");*/
        String token = (String) headers.get("x-token");
        return RetResponse.SuccessRsp(checkLoginService.GetUserInfo(token));
    }

    /*退出登录*/
    @PostMapping(value = "/loginOut")
    public RetResponse LoginOut() {
        return RetResponse.SuccessRsp("退出登录成功！");

    }

}
