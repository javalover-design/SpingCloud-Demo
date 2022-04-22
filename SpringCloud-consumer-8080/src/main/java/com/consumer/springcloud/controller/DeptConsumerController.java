package com.consumer.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lambda
 */
@RestController
public class DeptConsumerController {

    /**
     * 注入处理RestFul风格请求的模板类
     */
    @Resource
    private RestTemplate restTemplate;

    /**
     * 由于需要从远程的服务提供者获取相应的资源，所以需要设置远程提供者资源请求的固定前缀
     */
    private static final String REST_URL_PREFIX = "http://localhost:8001";


    /**
     * 通过该方法远程获取指定id的Dept对象
     * 获取对象使用get方式
     *
     * @param id
     * @return
     */
    @RequestMapping("/getDept/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        //此处需要使用到restTemplate对象的方法,该方法需要传入远程的资源地址以及返回值的Class类型
        //此处url地址的书写需要和远程服务端的controller请求的地址保持一致。
       return restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, Dept.class);
    }

    /**
     * 通过addDept方法提交一个内容，使用post方式请求
     * @param dept
     * @return
     */
    @RequestMapping("/addDept")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/add",dept,Boolean.class);
    }

    /**
     * 获取所有的内容，远程调用依旧是get方式
     * @return
     */
    @RequestMapping("/getList")
    public List<Dept> getDepts(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/list",List.class);
    }

}
