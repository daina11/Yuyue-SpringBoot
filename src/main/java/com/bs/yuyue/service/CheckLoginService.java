package com.bs.yuyue.service;

import com.bs.yuyue.dao.UserDao;
import com.bs.yuyue.pojo.User;
import com.bs.yuyue.utils.MD5Utils;
import com.bs.yuyue.vo.RetResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;

/*用户登录CheckLogin
获取用户信息GetUserInfo
*/
@Service
public class CheckLoginService {
    @Autowired
    UserDao userDao;

    public RetResponse CheckLogin(String username, String pwd) {
        String Md5pwd = MD5Utils.md5(pwd);
        //判断登录成功后生成token
        User u = userDao.findByName(username);
        if (u != null) {
            if (Md5pwd.equals(u.getPassword())) {
                //如果验证成功生成token 在验证token的正确
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();
                map.put("uid", u.getId());
                builder.setSubject(username)//主题token中携带的数据
                        .setIssuedAt(new Date())//设置token的生成时间
                        .setId(u.getId() + "")//设置用户id为token的id
                        .setClaims(map)//map中可以放用户的角色信息 管理员等
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))//设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "daina")//设置加密方式和加密密码
                        .compact();
                //返回token builder.compact()
                return RetResponse.SuccessToken(builder.compact());
            } else {
                return RetResponse.ErrRsp("账户或密码错误！");
            }
        } else {
            return RetResponse.ErrRsp("账户或密码错误！");
        }

    }


    /*获取用户信息*/
    public User GetUserInfo(String token) {
        //解析token中的uid 获取用户信息
        Claims claims;
        claims = Jwts.parser()
                .setSigningKey("daina")
                .parseClaimsJws(token)
                .getBody();
        int uid = (int) claims.get("uid");
        return userDao.findById(uid);
    }

    /*退出登录*/
    public RetResponse LoginOut(){

        return RetResponse.SuccessRsp("退出登录成功！");
    }
}
