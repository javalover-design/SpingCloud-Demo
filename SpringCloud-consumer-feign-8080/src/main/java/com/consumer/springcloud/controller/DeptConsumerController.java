package com.consumer.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.example.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lambda
 */
@RestController
public class DeptConsumerController {


    /***
     * 将deptClientService对象注入到当前项目中
     */
    @Resource
    private DeptClientService deptClientService;


    /**
     * 通过该方法远程获取指定id的Dept对象
     * 获取对象使用get方式
     *
     * @param id
     * @return
     */
    @RequestMapping("/getDept/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        return this.deptClientService.queryDeptById(id);
    }

    /**
     * 通过addDept方法提交一个内容，使用post方式请求
     * @param dept
     * @return
     */
    @RequestMapping("/addDept")
    public boolean addDept(Dept dept){
        return this.deptClientService.addDept(dept);
    }

    /**
     * 获取所有的内容，远程调用依旧是get方式
     * @return
     */
    @RequestMapping("/getList")
    public List<Dept> getDepts(){
        return this.deptClientService.queryAllDept();
    }

}
