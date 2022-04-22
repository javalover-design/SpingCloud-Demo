package com.provider.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.provider.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**@RequestBody
     * 注解表示主要接收前端传递给后端的json字符串中的数据（即请求体中的数据，一般与post请求一起使用）
     * */
    public boolean addDept(@RequestBody Dept dept){
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
