package com.bs.yuyue.dao;


import com.bs.yuyue.pojo.Orderitem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderitemDao extends JpaRepository<Orderitem,Integer> {
    Page<Orderitem> findAllByOpenidAndStatusOrderByTimeDesc(Pageable pageable,String openid,int status);
}
