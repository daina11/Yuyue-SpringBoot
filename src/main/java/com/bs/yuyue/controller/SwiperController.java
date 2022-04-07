package com.bs.yuyue.controller;

import com.bs.yuyue.service.SwiperService;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SwiperController {
    @Autowired
    SwiperService swiperService;
    @GetMapping(value = "/wx/other/getswiper")
    public RetResponse getswiper() {
        return  swiperService.getswiper();
    }
}
