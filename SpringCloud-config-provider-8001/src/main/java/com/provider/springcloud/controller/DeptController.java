package com.provider.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.provider.springcloud.service.DeptService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lambda
 * 这个控制层对象提供Restful风格的服务
 */
@RestController
@Accessors(chain = true)
public class DeptController {
    @Resource
    private DiscoveryClient discoveryClient;

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


    /**
     * 通过url获取一些info的注册信息
     * 可以通过该方法获取注册到Eureka服务中心的一些客户端信息
     * @return
     */
    @GetMapping("/discovery")
    public Object discovery(){
        //获取所有微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("所有的微服务列表："+services);
        //获取所有的信息实例
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getUri()+","+instance.getHost()+","+instance.getPort());
        }
        return this.discoveryClient;
    }


}
