package com.baizhi.service;

import com.baizhi.entity.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> selectAll();

    List<Supplier> slectByPage(int start, int rows);

    //添加
    void add(Supplier supplier);

    //修改
    void update(Supplier supplier);

    //删除
    void delete(String id);

    //模糊查询
    List<Supplier> selectLike(Supplier supplier);

    List<Supplier> selectLikeLeader(Supplier supplier);

}
