package com.bs.yuyue.controller;

import com.bs.yuyue.service.wxCheckLoginService;
import com.bs.yuyue.service.wxGetOpendIdService;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class wxLoginController {
    @Autowired
    wxGetOpendIdService wxgetOpendIdService;
    @Autowired
    wxCheckLoginService wxcheckLoginService;
    @GetMapping(value = "/wx/user/login")
    public RetResponse GetUserinfo(@RequestParam String code) {

       //注意code只能用一次 调用接口后直接失效
        Map data = wxgetOpendIdService.getSessionKeyOropenid(code);
        String openid = (String) data.get("openid");
        return wxcheckLoginService.wxCheckLogin(openid);
    }
    @PostMapping(value = "/wx/user/saveinfo")
    public RetResponse Saveinfo(@RequestBody Map map) {

        return wxcheckLoginService.saveinfo(map);
    }
}
