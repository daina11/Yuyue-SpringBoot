package com.bs.yuyue.service;

import com.bs.yuyue.dao.UserDao;
import com.bs.yuyue.pojo.User;
import com.bs.yuyue.utils.MD5Utils;
import com.bs.yuyue.vo.RetResponse;
import com.bs.yuyue.vo.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserDao userDao;

    public RetResult register(String username, String password) {
        User user = userDao.findByName(username);
        if (user != null) {
            return RetResponse.ErrRsp("用户名已存在！");
        } else {
            try {
                //加密密码
                String md5pwd = MD5Utils.md5(password);
                User u = new User();
                u.setName(username);
                u.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
                u.setPassword(md5pwd);
                userDao.save(u);
                return RetResponse.SuccessRsp("注册成功");
            } catch (Exception e) {
                return RetResponse.ErrRsp("注册失败");
            }
        }
    }
}
