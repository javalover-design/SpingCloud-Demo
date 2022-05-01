package com.example.springcloud.service;

import com.example.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lambda
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory {

    @Override
    public DeptClientService create(Throwable throwable) {
        //当前服务调用失败的时候，会反馈服务消费方一整个服务信息（DeptClientService）
        return new DeptClientService() {
            @Override
            public Dept queryDeptById(long id) {
                return new Dept().setDeptno(id)
                        .setDname(id+"没有对应的信息，并且该服务已经关闭了.....")
                        .setDb_source("MySQL中没有此信息");
            }

            @Override
            public List<Dept> queryAllDept() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
