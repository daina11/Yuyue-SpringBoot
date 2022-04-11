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
    //分页获取商店列表
    @GetMapping(value = "/wx/other/getshop")
    public RetResponse getShop(@RequestParam int page) {
        return  shopService.getShop(page);
    }
    //根据id查找商店
    @GetMapping(value = "/wx/other/getshopbyid")
    public RetResponse getshopByid(@RequestParam int id) {
        return  shopService.getById(id);
    }
}
