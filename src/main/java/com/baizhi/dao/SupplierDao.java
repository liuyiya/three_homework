package com.baizhi.dao;

import com.baizhi.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierDao extends BaseDao<Supplier> {
    List<Supplier> selectByPage(
            @Param("start") int start,
            @Param("rows") int rows
    );

    List<Supplier> selectLike(Supplier supplier);

    List<Supplier> selectLikeLeader(Supplier supplier);

}

