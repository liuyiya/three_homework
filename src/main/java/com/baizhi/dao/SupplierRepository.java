package com.baizhi.dao;

import com.baizhi.entity.Supplier;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SupplierRepository extends ElasticsearchRepository<Supplier, String> {
}
