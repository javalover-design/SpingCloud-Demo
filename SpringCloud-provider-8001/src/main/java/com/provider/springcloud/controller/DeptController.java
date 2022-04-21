package com.provider.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.provider.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lambda
 * 这个控制层对象提供Restful风格的服务
 */
@RestController
public class DeptController {

    private DeptService deptService;
    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 编写添加方法
     * @param dept
     * @return
     */
    @PostMapping("/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    /**
     * 使用restful风格的写法获取单个部门
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryDeptById(id);
    }

    /**
     * 查询所有的部门信息
     * @return
     */
    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAllDept();
    }




}
