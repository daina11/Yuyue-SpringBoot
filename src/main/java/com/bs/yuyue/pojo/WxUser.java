package com.bs.yuyue.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WxUser {
  @Id
  private String openid;
  private String nickname;
  private String avatarurl;
  private int deleted;


  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }


  public String getAvatarurl() {
    return avatarurl;
  }

  public void setAvatarurl(String avatarurl) {
    this.avatarurl = avatarurl;
  }


  public int getDeleted() {
    return deleted;
  }

  public void setDeleted(int deleted) {
    this.deleted = deleted;
  }

}
