package com.bs.yuyue.service;

import com.bs.yuyue.dao.OrderitemDao;
import com.bs.yuyue.pojo.Orderitem;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderitemService {
    @Autowired
    OrderitemDao orderitemDao;

    public void postOrder(Orderitem orderitem){
        orderitemDao.save(orderitem);
        return ;
    }
}
