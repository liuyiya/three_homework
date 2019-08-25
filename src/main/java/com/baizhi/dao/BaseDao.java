package com.baizhi.dao;

import java.util.List;

public interface BaseDao<T> {

    void insert(T t);

    void update(T t);

    void delete(String id);

    T select(T t);

    List<T> selectAll();

    T selectById(T t);

    T selectByUP(T t);
}
