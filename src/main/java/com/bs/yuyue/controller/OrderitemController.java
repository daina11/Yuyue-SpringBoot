package com.bs.yuyue.controller;

import com.bs.yuyue.pojo.Orderitem;
import com.bs.yuyue.service.OrderitemService;
import com.bs.yuyue.utils.UpdateImg;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        String peoplenumber =String.valueOf(ci.get("peoplenumber"));
        String name = (String) ci.get("name");
        Orderitem oi = new Orderitem();
        oi.setOpenid(openid);
        oi.setTime(time);
        oi.setShopid(Integer.parseInt(shopid));
        oi.setPhone(phone);
        oi.setPeoplenumber(Integer.parseInt(peoplenumber));
        oi.setName(name);
        orderitemService.postOrder(oi);
        return RetResponse.SuccessRsp("预约成功！");
    }
    //获取为完成订单
    @GetMapping(value = "/wx/other/getorderunsuccess")
    public RetResponse getorderunsuccess(@RequestParam String openid) {
        return  orderitemService.getorderBypid(openid);
    }
    //获取已完成订单 getordersuccess
    @GetMapping(value = "/wx/other/getordersuccess")
    public RetResponse getordersuccess(@RequestParam String openid) {
        return  orderitemService.getordersuccess(openid);
    }
    //获取过期订单getoutTiemOrder
    @GetMapping(value = "/wx/other/getouttimeorder")
    public RetResponse getouttimeorder(@RequestParam String openid) {
        return  orderitemService.getoutTiemOrder(openid);
    }
    //删除订单delorder
    @GetMapping(value = "/wx/other/delorder")
    public RetResponse delorder (@RequestParam int id) {
        try {
            orderitemService.delorder(id);
            return RetResponse.SuccessRsp("取消订单成功");
        }catch (Exception e){
            return RetResponse.ErrRsp("取消订单失败");
        }
    }
    //查找所有该商店订单getAllbyID
    @GetMapping(value = "/getallbysid")
    public RetResponse getallbysid (@RequestParam int sid,int page) {
        int id =sid;
        return orderitemService.getAllbyID(sid,page);
    }
    //后台商店ID查找所有未完成订单shopfindbystutas
    @GetMapping(value = "/shopfindbystutas")
    public RetResponse shopfindbystutas (@RequestParam int sid,int page) {
        return orderitemService.shopfindbystutas(sid,page);
    }
    //后台设置到店，订单已完成
    @PostMapping(value = "/succeeorder")
    public RetResponse succeeorder(@RequestBody Map<String, Object> ci) {
        int id = (int) ci.get("id");
        System.out.println(id);
        Orderitem o = orderitemService.findById(id);
        o.setStatus(1);
        orderitemService.saveorder(o);
        return RetResponse.SuccessRsp("订单已完成！");
    }
}
