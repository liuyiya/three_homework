package com.baizhi.service;

import com.baizhi.dao.SupplierDao;
import com.baizhi.dao.SupplierRepository;
import com.baizhi.entity.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductEs {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierDao supplierDao;
    @Autowired
    private CustomRepository customRepository;

    @Test
    //添加数据
    public void add() {
        List<Supplier> suppliers = supplierDao.selectAll();
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
            supplierRepository.save(supplier);
        }
    }
}
