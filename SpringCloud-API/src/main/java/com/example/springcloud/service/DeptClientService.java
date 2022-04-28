package com.example.springcloud.service;

import com.example.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * The interface Dept client service.
 * @author lambda
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    /**
     * Query dept by id dept.
     *
     * @param id the id
     * @return the dept
     */
    @GetMapping("/get/{id}")
    Dept queryDeptById(@PathVariable("id") long id);

    /**
     * Query all dept list.
     *
     * @return the list
     */
    @GetMapping("/list")
    List<Dept> queryAllDept();

    /**
     * Add dept boolean.
     *
     * @param dept the dept
     * @return the boolean
     */
    @PostMapping("/add")
    boolean addDept(Dept dept);


}
