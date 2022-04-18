package com.bs.yuyue.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class UpdateImg {
    public static String Updateimg(MultipartFile file) throws Exception {
//        String username = user.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        System.out.println(username);

        String folder = "E:/img";
        File imageFolder = new File(folder);

        //获取当前时间戳和随机数拼接避免重名
        String date = String.valueOf(new Date().getTime());

        //后面-4是保留文件后缀
        File f = new File(imageFolder, StringUtils.getRandomString(6) + date + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://img.yuyue.com/" + f.getName();

            //把图片链接赋值给全局变量
            return imgURL;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
