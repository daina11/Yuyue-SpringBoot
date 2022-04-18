package com.bs.yuyue.controller;

import com.bs.yuyue.utils.UpdateImg;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@CrossOrigin
public class ShopinfoController {
    @PostMapping(value = "/updateimg")
    public String updateimg(@RequestBody MultipartFile file) {
        MultipartFile f = file;
        try {
            return UpdateImg.Updateimg(f);
        } catch (Exception e) {
            return "上传图片出错！";
        }

    }
}
