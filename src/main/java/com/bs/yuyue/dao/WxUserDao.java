package com.bs.yuyue.dao;

import com.bs.yuyue.pojo.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WxUserDao extends JpaRepository<WxUser,Integer> {
    WxUser findByOpenid(String openid);

}
