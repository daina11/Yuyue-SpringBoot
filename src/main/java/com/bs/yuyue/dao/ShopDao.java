package com.bs.yuyue.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.bs.yuyue.pojo.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopDao extends JpaRepository<Shop,Integer> {
    Page<Shop> findAll(Pageable pageable);
    Shop findById(int id);
    Shop findByUserid(int uid);
    Page<Shop> findAllBySubscribeStatusId(Pageable pageable,int Subscribe_status);
    Page<Shop> findAllBySubscribeStatusIdOrderByPriceAsc(Pageable pageable,int Subscribe_status);
    Page<Shop> findAllBySubscribeStatusIdOrderByPriceDesc(Pageable pageable,int Subscribe_status);
    Page<Shop> findAllByNameLikeOrTitleLikeOrLocationLike(Pageable pageable,String text,String t,String ts);
    Page<Shop> findAllByCategoryId(Pageable pageable,int cid);
}
