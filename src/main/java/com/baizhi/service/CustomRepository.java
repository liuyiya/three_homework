package com.baizhi.service;

import com.baizhi.entity.Supplier;

import java.util.List;

public interface CustomRepository {
    // 自定义term查询
    List<Supplier> findByNameTerm(String name);

    //自定义模糊查询
    List<Supplier> findLikeName(String name);

}
