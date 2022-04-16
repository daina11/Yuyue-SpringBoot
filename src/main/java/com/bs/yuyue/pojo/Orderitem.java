package com.bs.yuyue.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})//防止信息格式化位json时有字段为null 报错
public class Orderitem {
  @Id
  private int id;
  private String time;
  private String openid;
  private int shopid;
  private String phone;
  private int status;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }


  public int getShopid() {
    return shopid;
  }

  public void setShopid(int shopid) {
    this.shopid = shopid;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shopid", referencedColumnName = "id", insertable = false, updatable = false)
  private Shop shop;

  public Shop getShop() {
    return shop;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }
}
