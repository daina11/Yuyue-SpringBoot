package com.bs.yuyue.dao;


import com.bs.yuyue.pojo.Swiper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwiperDao extends JpaRepository<Swiper,Integer> {
    List<Swiper> findAllByIdIsNotNull();
}
