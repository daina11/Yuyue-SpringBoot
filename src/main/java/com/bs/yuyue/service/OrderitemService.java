package com.bs.yuyue.service;

import com.bs.yuyue.dao.OrderitemDao;
import com.bs.yuyue.pojo.Orderitem;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderitemService {
    @Autowired
    OrderitemDao orderitemDao;

    public void postOrder(Orderitem orderitem){
        orderitemDao.save(orderitem);
        return ;
    }
    //查找所有该商店订单
    public RetResponse getAllbyID(int sid,int page){
        return RetResponse.SuccessRsp(orderitemDao.findAllByShopidOrderByTimeDesc(PageRequest.of(page, 10),sid));
    }
    //根据id查找订单findById
    public Orderitem findById(int id){
        return orderitemDao.findById(id);
    }
    //查找未完成订单
    public RetResponse getorderBypid(String oid){
        List<Orderitem> list =orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,0);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式(年-月-日-时-分-秒)
        String nowtime = dateFormat.format(now);
        for (Orderitem orderitem:list
        ) {
            if(orderitem.getTime().compareTo(nowtime)<0&&orderitem.getStatus()!=1){

                orderitem.setStatus(2);
                orderitemDao.save(orderitem);
            }
        }
        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,0));
    }
    //查找已完成订单
    public RetResponse getordersuccess(String oid){
        List<Orderitem> list =orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,1);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式(年-月-日-时-分-秒)
        String nowtime = dateFormat.format(now);
        for (Orderitem orderitem:list
             ) {
                if(orderitem.getTime().compareTo(nowtime)<0&&orderitem.getStatus()!=1){

                    orderitem.setStatus(2);
                    orderitemDao.save(orderitem);
                }
        }

        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,1));
    }
    //获取过期订单
    public RetResponse getoutTiemOrder(String oid){
        List<Orderitem> list =orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,1);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式(年-月-日-时-分-秒)
        String nowtime = dateFormat.format(now);
        for (Orderitem orderitem:list
        ) {
            if(orderitem.getTime().compareTo(nowtime)<0&&orderitem.getStatus()!=1){

                orderitem.setStatus(2);
                orderitemDao.save(orderitem);
            }
        }
        return RetResponse.SuccessRsp(orderitemDao.findAllByOpenidAndStatusOrderByTimeDesc(oid,2));
    }
    //取消订单 删除
    //查找已完成订单
    public RetResponse delorder(int id){
        return RetResponse.SuccessRsp(orderitemDao.deleteById(id));
    }
    //后台获取未完成订单findAllByShopidAndStatusOrderByTimeDesc
    public RetResponse shopfindbystutas(int sid,int page){
        List<Orderitem> list =orderitemDao.findAllByStatus(0);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式(年-月-日-时-分-秒)
        String nowtime = dateFormat.format(now);
        for (Orderitem orderitem:list
        ) {
            if(orderitem.getTime().compareTo(nowtime)<0&&orderitem.getStatus()!=1){

                orderitem.setStatus(2);
                orderitemDao.save(orderitem);
            }
        }
        return RetResponse.SuccessRsp(orderitemDao.findAllByShopidAndStatusOrderByTimeDesc(PageRequest.of(page, 10),sid,0));
    }
    public void saveorder(Orderitem orderitem){
        orderitemDao.save(orderitem);
    }
}
