package com.bs.yuyue.dao;


import com.bs.yuyue.pojo.Orderitem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderitemDao extends JpaRepository<Orderitem,Integer> {
    List<Orderitem> findAllByOpenidAndStatusOrderByTimeDesc(String openid, int status);
    Orderitem deleteById(int id);
    Orderitem findById(int id);
    Page<Orderitem> findAllByShopidOrderByTimeDesc(Pageable pageable,int id);
    Page<Orderitem> findAllByShopidAndStatusOrderByTimeDesc(Pageable pageable,int sid,int stutas);
    List<Orderitem> findAllByStatus(int s);
}
