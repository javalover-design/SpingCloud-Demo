package com.provider.springcloud.service;

import com.example.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author lambda
 */

public interface DeptService {
    /**
     * Query all dept list.
     *查询所有的部门，返回一个部门的list集合
     * @return the list
     */

    List<Dept> queryAllDept();

    /**
     * Add dept boolean.
     *添加一个部门，最后返回结果的布尔值
     * @param dept the dept
     * @return the boolean
     */
    boolean addDept(Dept dept);

    /**
     * Query dept by id dept.
     *通过id查询一个部门
     * @param id the id
     * @return the dept
     */
    Dept queryDeptById(long id);

}
