package com.bs.yuyue.controller;

import com.bs.yuyue.pojo.Orderitem;
import com.bs.yuyue.service.OrderitemService;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class OrderitemController {
    @Autowired
    OrderitemService orderitemService;
    @PostMapping(value = "/wx/other/postorder")
    public RetResponse postorder(@RequestBody Map<String, Object> ci) {
        String openid = String.valueOf(ci.get("openid"));
        String time = String.valueOf(ci.get("time"));
        String shopid = String.valueOf(ci.get("shopid"));
        String phone = String.valueOf(ci.get("phone"));
        Orderitem oi = new Orderitem();
        oi.setOpenid(openid);
        oi.setTime(time);
        oi.setShopid(Integer.parseInt(shopid));
        oi.setPhone(phone);
        orderitemService.postOrder(oi);
        return RetResponse.SuccessRsp("预约成功！");
    }
    //获取为完成订单
    @GetMapping(value = "/wx/other/getorderunsuccess")
    public RetResponse getorderunsuccess(@RequestParam int page,String openid) {
        return  orderitemService.getorderBypid(page,openid);
    }
    //获取已完成订单 getordersuccess
    @GetMapping(value = "/wx/other/getordersuccess")
    public RetResponse getordersuccess(@RequestParam int page,String openid) {
        return  orderitemService.getordersuccess(page,openid);
    }
}
