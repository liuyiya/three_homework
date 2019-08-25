package com.baizhi.service;

import com.baizhi.dao.SupplierDao;
import com.baizhi.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> selectAll() {
        List<Supplier> suppliers = supplierDao.selectAll();
        return suppliers;
    }

    @Override
    public List<Supplier> slectByPage(int start, int rows) {
        List<Supplier> suppliers = supplierDao.selectByPage(start, rows);
        return suppliers;
    }

    @Override
    public void add(Supplier supplier) {
        supplierDao.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public void delete(String id) {
        supplierDao.delete(id);
    }

    @Override
    public List<Supplier> selectLike(Supplier supplier) {
        List<Supplier> suppliers = supplierDao.selectLike(supplier);
        return suppliers;
    }

    @Override
    public List<Supplier> selectLikeLeader(Supplier supplier) {
        List<Supplier> suppliers = supplierDao.selectLike(supplier);
        return suppliers;
    }
}
