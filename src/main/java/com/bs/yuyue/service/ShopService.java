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
        Page list = shopDao.findAllBySubscribeStatusId(PageRequest.of(page, 4),0);
        return RetResponse.SuccessRsp(list);
    }
    public RetResponse getById(int id){
        return RetResponse.SuccessRsp(shopDao.findById(id));
    }
    //根据价格升序
    public RetResponse getShopBypriceAsc(int page){
        Page list = shopDao.findAllBySubscribeStatusIdOrderByPriceAsc(PageRequest.of(page, 4),0);
        return RetResponse.SuccessRsp(list);
    }
    //根据价格降序findAllByStatusOrderByPriceDesc
    public RetResponse getShopBypriceDesc(int page){
        Page list = shopDao.findAllBySubscribeStatusIdOrderByPriceDesc(PageRequest.of(page, 4),0);
        return RetResponse.SuccessRsp(list);
    }
    //搜索 findAllByNameAndTitleLike
    public RetResponse searchBynameAndTitle(int page,String text){
        Page list = shopDao.findAllByNameLikeOrTitleLike(PageRequest.of(page, 4),"%"+text+"%","%"+text+"%");
        return RetResponse.SuccessRsp(list);
    }
}
