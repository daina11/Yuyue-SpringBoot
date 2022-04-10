package com.bs.yuyue.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.bs.yuyue.dao.ShopDao;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {
    @Autowired
    ShopDao shopDao;
    public RetResponse getShop(int page) {
        Page list = shopDao.findAll(PageRequest.of(page, 4));
        return RetResponse.SuccessRsp(list);
    }
}
