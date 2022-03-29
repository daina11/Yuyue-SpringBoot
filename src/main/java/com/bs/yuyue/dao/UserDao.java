package com.bs.yuyue.dao;

import com.bs.yuyue.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findById(int id);
    User findByName(String Username);
}
