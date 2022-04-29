package com.provider.springcloud.controller;

import com.example.springcloud.pojo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.provider.springcloud.service.DeptService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @HystrixCommand(fallbackMethod = "addDeptHystrix")
    /**@RequestBody
     * 注解表示主要接收前端传递给后端的json字符串中的数据（即请求体中的数据，一般与post请求一起使用）
     * */
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    /**
     * 表示addDept的备用方法，如果addDept方法调用失败，则启动该方法。
     * @param dept
     * @return
     */
    public boolean addDeptHystrix(Dept dept){
        return false;
    }

    /**
     * 使用restful风格的写法获取单个部门
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        return deptService.queryDeptById(id);
    }

    /**
     * 这是get方法的备用方法，当get失败后，则会调用该方法
     * @param id
     * @return
     */

    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDeptno(id)
                .setDname("没有对应id的相关信息（由Hystrix提供）")
                .setDb_source("We have none such database in  MySQL");
    }

    /**
     * 查询所有的部门信息
     * @return
     */
    @GetMapping("/list")
    @HystrixCommand(fallbackMethod = "queryAllHystrix")
    public List<Dept> queryAll(){
        return deptService.queryAllDept();
    }

    /**
     * queryAll的备用方法
     * @return
     */
    public List<Dept> queryALlHystrix(){
        List<Dept> list=new ArrayList<>();
        list.add(new Dept().setDeptno(1).setDname("空").setDb_source(""));
        list.add(new Dept().setDeptno(2).setDname("").setDb_source(""));

        return list;
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
