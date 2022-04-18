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
    public RetResponse getorderBypid(String oid){

        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,0));
    }
    //查找已完成订单
    public RetResponse getordersuccess(String oid){

        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,1));
    }
    //取消订单 删除
    //查找已完成订单
    public RetResponse delorder(int id){
        return RetResponse.SuccessRsp(orderitemDao.deleteById(id));
    }
}
