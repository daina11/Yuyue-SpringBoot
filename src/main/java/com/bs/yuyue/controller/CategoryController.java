package com.bs.yuyue.controller;

import com.bs.yuyue.service.CategoryService;
import com.bs.yuyue.vo.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/wx/other/getcategory")
    public RetResponse getcategory() {
       return  categoryService.GetAllCategory();
    }

}
