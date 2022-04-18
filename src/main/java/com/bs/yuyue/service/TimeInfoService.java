package com.bs.yuyue.service;

import com.bs.yuyue.dao.TimeinfoDao;
import com.bs.yuyue.pojo.Timeinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeInfoService {
    @Autowired
    TimeinfoDao timeinfoDao;
    public void saveTimeinfo(Timeinfo timeinfo){
        timeinfoDao.save(timeinfo);
        return;
    }
}
