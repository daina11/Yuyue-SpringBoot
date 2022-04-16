package com.bs.yuyue.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Swiper {
  @Id
  private int id;
  private String imgurl;
  private long shopId;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }


  public long getShopId() {
    return shopId;
  }

  public void setShopId(long shopId) {
    this.shopId = shopId;
  }

}
