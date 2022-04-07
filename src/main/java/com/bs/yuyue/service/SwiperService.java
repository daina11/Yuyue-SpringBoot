package com.bs.yuyue.service;

import com.bs.yuyue.dao.SwiperDao;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiperService {
    @Autowired
    SwiperDao swiperDao;
    public RetResponse getswiper() {
        return RetResponse.SuccessRsp(swiperDao.findAllByIdIsNotNull());
    }
}
