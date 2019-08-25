package com.baizhi.controller;

import com.baizhi.entity.Supplier;
import com.baizhi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("selectByPage")
    public Map<String, Object> showByPage(int page, int rows) {
        List<Supplier> suppliers = supplierService.selectAll();
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", page);
        int totals = suppliers.size();
        int total = 0;
        if (totals % rows == 0) {
            total = totals / rows;
        } else {
            total = totals / rows + 1;
        }
        //rows=一页多少条数据  page=当前页数  start：一页中开始的条数 total：总页数
        int start = (page - 1) * rows;
        List<Supplier> suppliers1 = supplierService.slectByPage(start, rows);
        System.out.println("一页多少数据" + suppliers1);
        map.put("rows", suppliers1);
        map.put("total", total);
        map.put("records", totals);
        return map;
    }

    // oper  代表请求的操作是什么 |  add/del/edit
    @ResponseBody
    @RequestMapping("operSupplier")
    public Map<String, String> operSupplier(String oper, Supplier supplier) {
        HashMap hashMap = new HashMap();
        if ("add".equals(oper)) {
            supplier.setId(UUID.randomUUID().toString());
            supplierService.add(supplier);
            System.out.println("添加：" + supplier);
            hashMap.put("status", "addOk");
            return hashMap;
        } else if ("del".equals(oper)) {
            supplierService.delete(supplier.getId());
            System.out.println("删除");
            hashMap.put("status", "delOk");
            return hashMap;
        } else if ("edit".equals(oper)) {
            supplierService.update(supplier);
            System.out.println("修改");
            hashMap.put("status", "updateOk");
            return hashMap;
        } else {
            hashMap.put("status", "error");
            return hashMap;
        }
    }

    //模糊查询
    @RequestMapping("like")
    public List<Supplier> like(Supplier supplier, String option) {
        System.out.println("option:" + option);
        List<Supplier> suppliers;
        if (option.equals("name")) {
            suppliers = supplierService.selectLike(supplier);
            return suppliers;
        } else if (option.equals("leader")) {
            System.out.println("输入的值：" + supplier);
            suppliers = supplierService.selectLikeLeader(supplier);
            System.out.println("leader:" + suppliers);
            return suppliers;
        } else {
            return null;
        }

    }
}
