package com.bs.yuyue.service;

import com.bs.yuyue.dao.OrderitemDao;
import com.bs.yuyue.pojo.Orderitem;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderitemService {
    @Autowired
    OrderitemDao orderitemDao;

    public void postOrder(Orderitem orderitem){
        orderitemDao.save(orderitem);
        return ;
    }
    //查找未完成订单
    public RetResponse getorderBypid(int page,String oid){

        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(PageRequest.of(page, 5),oid,0));
    }
    //查找已完成订单
    public RetResponse getordersuccess(int page,String oid){

        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(PageRequest.of(page, 5),oid,1));
    }
}
