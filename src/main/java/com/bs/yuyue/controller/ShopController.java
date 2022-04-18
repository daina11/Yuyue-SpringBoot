package com.bs.yuyue.controller;

import com.bs.yuyue.pojo.Shop;
import com.bs.yuyue.pojo.Timeinfo;
import com.bs.yuyue.service.ShopService;
import com.bs.yuyue.service.TimeInfoService;
import com.bs.yuyue.utils.UpdateImg;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    TimeInfoService timeInfoService;
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
    //根据分类查找
    @GetMapping(value = "/wx/other/getbycid")
    public RetResponse getbycid(@RequestParam int page,int cid) {
        return  shopService.findByCid(page,cid);
    }

    //后台商家新增商店
    @PostMapping(value = "/saveshop")
    public RetResponse saveshop(@RequestBody Map<String, Object> ci) {
      Shop s=  shopService.findbyUid((Integer) ci.get("uid"));
      if(s==null){
          Shop shop = new Shop();
          shop.setUserid((Integer) ci.get("uid"));

          shop.setName((String) ci.get("name"));
          shop.setPrice((Integer) ci.get("price"));
          shop.setTitle((String) ci.get("title"));
          shop.setCategoryId((Integer) ci.get("fenlei"));
          boolean open = (boolean) ci.get("open");
          if(open){
              shop.setSubscribeStatusId(0);
          }else {
              shop.setSubscribeStatusId(1);
          }
          shop.setLocation((String) ci.get("location"));
          shop.setPhone(ci.get("phone").toString());
          shop.setImgurl((String) ci.get("imgurl"));
          s.setBegintime((String) ci.get("date1"));
          s.setEndtime((String) ci.get("date2"));
          shopService.saveShop(shop);

      }else {
          s.setUserid((Integer) ci.get("uid"));

          s.setName((String) ci.get("name"));
          s.setPrice((Integer) ci.get("price"));
          s.setTitle((String) ci.get("title"));
          s.setCategoryId((Integer) ci.get("fenlei"));
          boolean open = (boolean) ci.get("open");
          if(open){
              s.setSubscribeStatusId(0);
          }else {
              s.setSubscribeStatusId(1);
          }
          s.setLocation((String) ci.get("location"));
          s.setPhone(ci.get("phone").toString());
          s.setImgurl((String) ci.get("imgurl"));
          s.setBegintime((String) ci.get("date1"));
          s.setEndtime((String) ci.get("date2"));
          shopService.saveShop(s);


      }


        return RetResponse.SuccessRsp("");
    }
    //根据uid获取商店信息getshopbyuid
    @GetMapping(value = "/getshopbyuid")
    public RetResponse getshopbyuid(@RequestParam int uid) {
        return  RetResponse.SuccessRsp(shopService.findbyUid(uid));
    }
}
