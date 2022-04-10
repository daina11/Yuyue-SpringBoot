package com.bs.yuyue.controller;

import com.bs.yuyue.service.ShopService;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ShopController {
    @Autowired
    ShopService shopService;
    @GetMapping(value = "/wx/other/getshop")
    public RetResponse getShop(@RequestParam int page) {
        return  shopService.getShop(page);
    }
}
