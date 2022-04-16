package com.bs.yuyue.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
  @Id
  private int id;
  private String imgurl;
  private String name;


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


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
