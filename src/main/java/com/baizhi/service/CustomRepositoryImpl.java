package com.baizhi.service;


import com.baizhi.entity.Supplier;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 把当前实现类交给spring工厂管理
public class CustomRepositoryImpl implements CustomRepository {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<Supplier> findByNameTerm(String name) {
        // 构建查询对象
        SearchQuery searchQuery = new NativeSearchQuery(QueryBuilders.termQuery("name", name));
        // 执行查询
        List<Supplier> suppliers = elasticsearchTemplate.queryForList(searchQuery, Supplier.class);
        return suppliers;
    }

    @Override
    //模糊查询实现
    public List<Supplier> findLikeName(String name) {
        return null;
    }
}
