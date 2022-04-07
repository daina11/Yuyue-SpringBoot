package com.bs.yuyue.service;

import com.bs.yuyue.dao.CategoryDao;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;
    public RetResponse GetAllCategory(){
        return RetResponse.SuccessRsp(categoryDao.findAllByIdIsNotNull());
    }
}
