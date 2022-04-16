package com.bs.yuyue.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})//防止信息格式化位json时有字段为null 报错
public class Shop {
  @Id
  private int id;
  private String name;
  private double price;
  private String title;
  private String imgurl;
  private int subscribeStatusId;
  private int status;
  private String phone;
  private String location;
  private String content;
  private int categoryId;
  private Integer hotindex;

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getHotindex() {
    return hotindex;
  }

  public void setHotindex(Integer hotindex) {
    this.hotindex = hotindex;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getSubscribeStatusId() {
    return subscribeStatusId;
  }

  public void setSubscribeStatusId(int subscribeStatusId) {
    this.subscribeStatusId = subscribeStatusId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "subscribeStatusId", referencedColumnName = "id", insertable = false, updatable = false)
  private SubscribeStatus subscribeStatus;

  public SubscribeStatus getSubscribeStatus() {
    return subscribeStatus;
  }

  public void setSubscribeStatus(SubscribeStatus subscribeStatus) {
    this.subscribeStatus = subscribeStatus;
  }

}
