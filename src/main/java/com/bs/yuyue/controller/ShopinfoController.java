package com.bs.yuyue.controller;

import com.bs.yuyue.pojo.Shop;
import com.bs.yuyue.service.ShopService;
import com.bs.yuyue.utils.UpdateImg;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin
public class ShopinfoController {
    @Autowired
    ShopService shopService;
    @PostMapping(value = "/updateimg")
    public RetResponse updateimg(@RequestBody MultipartFile file) {

        MultipartFile f = file;
        try {
            return RetResponse.SuccessRsp(UpdateImg.Updateimg(f));

        } catch (Exception e) {
            return RetResponse.ErrRsp("上传图片出错");
        }

    }
    //postintro
    @PostMapping(value = "/postintro")
    public RetResponse postintro(@RequestBody Map<String, Object> ci) {
        try {
            int uid = (int) ci.get("uid");
            Shop s = shopService.findbyUid(uid);
            String content = (String) ci.get("intro");
            s.setContent(content);
            shopService.saveShop(s);
            return RetResponse.SuccessRsp("修改成功");

        } catch (Exception e) {
            return RetResponse.ErrRsp("修改出错");
        }

    }
}
