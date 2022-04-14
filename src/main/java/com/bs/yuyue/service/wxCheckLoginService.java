package com.bs.yuyue.service;

import com.bs.yuyue.dao.WxUserDao;
import com.bs.yuyue.pojo.WxUser;
import com.bs.yuyue.vo.RetResponse;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class wxCheckLoginService {
    @Autowired
    WxUserDao wxUserDao;
    public RetResponse wxCheckLogin(String openid) {

        //通过获取到的openid查询数据库
        WxUser wxUser = wxUserDao.findByOpenid(openid);
        //如果查到的数据为空，就是第一次登录，将openid存入到数据库中，返回这条数据给前端，只有openid，nickname那些为空
        //前端通过拿到的数据中的nickname是否为空判断是否已经授权
        if (wxUser==null){
            WxUser w = new WxUser();
            w.setOpenid(openid);
            wxUserDao.save(w);
            return RetResponse.SuccessRsp(w);
        }else {
            //不为空返回数据库中的数据
            return RetResponse.SuccessRsp(wxUser);
        }

    }
    public RetResponse saveinfo(Map  userinfo){
        String openid = (String) userinfo.get("openid");
        String nickname =(String) userinfo.get("nickname");
        String avatarurl=(String) userinfo.get("avatarurl");
        WxUser w = new WxUser();
        w.setOpenid(openid);
        w.setNickname(nickname);
        w.setAvatarurl(avatarurl);
        wxUserDao.save(w);
        return RetResponse.SuccessRsp(w);
    }
}
