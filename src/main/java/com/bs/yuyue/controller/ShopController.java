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

    //热门
    //
    @GetMapping(value = "/wx/other/hotlist")
    public RetResponse getShopbyPriceAsc(@RequestParam int page,int type) {
        if(type==1){
            return  shopService.getShop(page);
        }else if(type==2){
            //价格低到高ASC
            return shopService.getShopBypriceAsc(page);
        }else{
            //价格高到低
            return shopService.getShopBypriceDesc(page);
        }
    }
    //搜索 searchBynameAndTitle
    @GetMapping(value = "/wx/other/search")
    public RetResponse search(@RequestParam int page,String text) {
        return  shopService.searchBynameAndTitle(page,text);
    }
}
