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
    //查过审状态的商店
    public RetResponse getShop(int page) {
        Page list = shopDao.findAllByStatus(PageRequest.of(page, 4),1);
        return RetResponse.SuccessRsp(list);
    }
    public RetResponse getById(int id){
        return RetResponse.SuccessRsp(shopDao.findById(id));
    }
}
