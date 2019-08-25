package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.entity.Supplier;
import com.baizhi.service.SupplierService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SupplierTest {
    @Autowired
    private SupplierService supplierService;

    @Test
    public void test() {
        List<Supplier> suppliers = supplierService.slectByPage(1, 2);
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
        }
    }

    @Test
    public void test02() {
        Supplier supplier = new Supplier();
        supplier.setName("阿里");
        List<Supplier> suppliers = supplierService.selectLike(supplier);
        for (Supplier supplier1 : suppliers) {
            System.out.println(supplier1);
        }
    }

    @Test
    public void test03() {
        Supplier supplier = new Supplier();
        supplier.setLeader("丁");
        List<Supplier> suppliers = supplierService.selectLikeLeader(supplier);
        for (Supplier supplier1 : suppliers) {
            System.out.println(supplier1);
        }
    }
}
