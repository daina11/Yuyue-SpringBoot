package com.bs.yuyue.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})//防止信息格式化位json时有字段为null 报错
public class Timeinfo {
  @Id
  private int id;
  private String begintime;
  private String endtime;
  private int shopid;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getBegintime() {
    return begintime;
  }

  public void setBegintime(String begintime) {
    this.begintime = begintime;
  }


  public String getEndtime() {
    return endtime;
  }

  public void setEndtime(String endtime) {
    this.endtime = endtime;
  }


  public int getShopid() {
    return shopid;
  }

  public void setShopid(int shopid) {
    this.shopid = shopid;
  }

}
