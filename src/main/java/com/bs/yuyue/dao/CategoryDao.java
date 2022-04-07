package com.bs.yuyue.dao;
import com.bs.yuyue.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao  extends JpaRepository<Category,Integer> {
    Category findById(int id);
    List<Category>  findAllByIdIsNotNull();
}
